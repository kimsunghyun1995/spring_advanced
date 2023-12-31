package hello.proxy;

import hello.proxy.Config.AppV1Config;
import hello.proxy.Config.AppV2Config;
import hello.proxy.Config.DynamicProxyBasicConfig;
import hello.proxy.Config.DynamicProxyFilterConfig;
import hello.proxy.Config.v1_proxy.ConcreteProxyConfig;
import hello.proxy.Config.v1_proxy.InterfaceProxyConfig;
import hello.proxy.trace.logtrace.LogTrace;
import hello.proxy.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = "hello.proxy.app.v3") //주의
//@Import({AppV2Config.class, AppV1Config.class})
@Import(DynamicProxyFilterConfig.class)
public class ProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyApplication.class, args);
	}

	@Bean
	public LogTrace logTrace() {
		return new ThreadLocalLogTrace();
	}
}