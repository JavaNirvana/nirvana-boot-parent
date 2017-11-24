package com.nirvana.boot.user;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

/**
 * 用户模块启动入口
 */
@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
        SpringApplication application = new SpringApplication(UserApplication.class);
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
