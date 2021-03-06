package com.nirvana.boot.web;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

/**
 * @EnableAutoConfiguration:spring boot的注解，一般只用于主类，
 * 是无xml配置启动的关键部分,明确指定了扫描包的路径为其修饰的主类的包（这也就是为什么主类要放在根包路径下的原因）
 *
 * @ComponentScan 进行包的扫描，扫描路径由@EnableAutoConfiguration指定了
 *
 * 主类要位于根包路径下，方便之后的扫描(We generally recommend that you locate your main application class in a root package above other classes.)
 */

/**
 * @SpringBootApplication相当于下面三个注解：
 * @Configuration 该注解指明该类由spring容器管理
 * @EnableAutoConfiguration 该注解是无xml配置启动的关键部分
 * @ComponentScan 该注解指定扫描包（如果主类不是位于根路径下，这里需要指定扫描路径），类似于spring的包扫描注解
 */
@SpringBootApplication
public class Application {

    /**
     * spring boot的入口，在整个项目中，包括其子项目在内，
     * 只能有一个main方法，否则spring boot启动不起来
     */
    public static void main(String[] args) {
        //SpringApplication.run(Application.class, args);
        SpringApplication application = new SpringApplication(Application.class);
        application.setBanner(new Banner(){
            @Override
            public void printBanner(Environment environment, Class<?> sourceClass, PrintStream printStream) {
                printStream.println("//                            _ooOoo_  ");
                printStream.println("//                           o8888888o");
                printStream.println("//                           88\" . \"88");
                printStream.println("//                           (| -_- |)");
                printStream.println("//                            O\\ = /O");
                printStream.println("//                        ____/`---'\\____");
                printStream.println("//                      .   ' \\\\| |// `.");
                printStream.println("//                       / \\\\||| : |||// \\");
                printStream.println("//                     / _||||| -:- |||||- \\");
                printStream.println("//                       | | \\\\\\ - /// | |");
                printStream.println("//                     | \\_| ''\\---/'' | |");
                printStream.println("//                      \\ .-\\__ `-` ___/-. /");
                printStream.println("//                   ___`. .' /--.--\\ `. . __");
                printStream.println("//                .\"\" '< `.___\\_<|>_/___.' >'\"\".");
                printStream.println("//               | | : `- \\`.;`\\ _ /`;.`/ - ` : | |");
                printStream.println("//                 \\ \\ `-. \\_ __\\ /__ _/ .-` / /");
                printStream.println("//         ======`-.____`-.___\\_____/___.-`____.-'======");
                printStream.println("//                            `=---='");
                printStream.println("//");
                printStream.println("//         .............................................");
                printStream.println("                      佛祖保佑             永无BUG");
            }
        });
        application.setBannerMode(Banner.Mode.CONSOLE);
        application.run(args);
    }
}
