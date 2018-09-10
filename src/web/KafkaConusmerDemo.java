package web;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.serializer.StringDecoder;
import kafka.utils.VerifiableProperties;

public class KafkaConusmerDemo {

	private static ConsumerConnector consumer;

	public String kafkaServer = "csfwq1:2181,csfwq1:2182,csfwq1:2183";

	private static final String TOPIC = "test";

	public KafkaConusmerDemo() {
		Properties props = new Properties();
		// zookeeper
		props.put("zookeeper.connect", kafkaServer);
		// group.id
		props.put("group.id", "test");
		// 是否自动修改偏移量offset，false代表手动修改
		props.put("enable.auto.commit", "false");
		// Zookeeper 超时
		props.put("zookeeper.session.timeout.ms", "4000");
		props.put("zookeeper.sync.time.ms", "200");
		// 序列化方法
		props.put("serializer.class", "kafka.serializer.StringEncoder");

		ConsumerConfig config = new ConsumerConfig(props);

		consumer = kafka.consumer.Consumer.createJavaConsumerConnector(config);
	}

	public void consume() {
		Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
		topicCountMap.put(TOPIC, new Integer(1));

		StringDecoder keyDecoder = new StringDecoder(new VerifiableProperties());
		StringDecoder valueDecoder = new StringDecoder(new VerifiableProperties());

		Map<String, List<KafkaStream<String, String>>> consumerMap = consumer.createMessageStreams(topicCountMap,
				keyDecoder, valueDecoder);
		KafkaStream<String, String> stream = consumerMap.get(TOPIC).get(0);
		ConsumerIterator<String, String> it = stream.iterator();

		// int messageCount = 0;
		while (it.hasNext()) {
			System.out.println(it.next().message());
			// 数据处理成功，提交偏移量
			if (true) {
				consumer.commitOffsets();
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("====开始====");
		new KafkaConusmerDemo().consume();
	}

}
