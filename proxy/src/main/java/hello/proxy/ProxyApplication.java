package hello.proxy;

import hello.proxy.Config.AppV1Config;
import hello.proxy.Config.AppV2Config;
import hello.proxy.Config.DynamicProxyBasicConfig;
import hello.proxy.Config.DynamicProxyFilterConfig;
import hello.proxy.Config.v1_proxy.ConcreteProxyConfig;
import hello.proxy.Config.v1_proxy.InterfaceProxyConfig;
import hello.proxy.Config.v3_proxyfactory.ProxyFactoryConfigV1;
import hello.proxy.Config.v3_proxyfactory.ProxyFactoryConfigV2;
import hello.proxy.Config.v4_postprocessor.BeanPostProcessorConfig;
import hello.proxy.Config.v5_autoproxy.AutoProxyConfig;
import hello.proxy.Config.v6_aop.AopConfig;
import hello.proxy.trace.logtrace.LogTrace;
import hello.proxy.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = "hello.proxy.app.v3") //주의
//@Import({AppV2Config.class, AppV1Config.class})
//@Import(DynamicProxyFilterConfig.class)
//@Import(ProxyFactoryConfigV2.class
//@Import(AutoProxyConfig.class)
@Import(AopConfig.class)
public class ProxyApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProxyApplication.class, args);
	}

	@Bean
	public LogTrace logTrace() {
		return new ThreadLocalLogTrace();
	}
}
