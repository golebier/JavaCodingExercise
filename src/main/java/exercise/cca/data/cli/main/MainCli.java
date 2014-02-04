package exercise.cca.data.cli.main;

import java.io.IOException;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;

import exercise.cca.data.read.impl.file.LoadDataFromFile;
import exercise.cca.data.read.impl.system.in.SystemIn;

public class MainCli {
    private static final int OK_EXIT_STATUS = 0;
    private static final String LOAD_THE_EXCHANGE_RATE_DATA_FROM_FILE_BEAN_ID = "loadTheExchangeRateDataFromFile";
    private static final String LOAD_DATA_FROM_FILE_BEAN_ID = "loadDataFromFile";
    private static final String CONTEXT_PATH = "main-context.xml";
    private static LoadDataFromFile loadDataFromFile;
    private static LoadDataFromFile loadTheExchangeRateDataFromFile;
    private static SystemIn loadDataFromSystemIn;

    public static void main(String[] args) throws IOException {
        final ConfigurableApplicationContext applicationContext = loadContext(CONTEXT_PATH);
        loadDataFromFile = applicationContext.getBean(
                LOAD_DATA_FROM_FILE_BEAN_ID, LoadDataFromFile.class);
        loadTheExchangeRateDataFromFile = applicationContext.getBean(
                LOAD_THE_EXCHANGE_RATE_DATA_FROM_FILE_BEAN_ID,
                LoadDataFromFile.class);
        loadDataFromSystemIn = applicationContext.getBean(SystemIn.class);

        new MainCli().run();
    }

    public void run() throws IOException {
        loadDataFromFile.load();
        loadTheExchangeRateDataFromFile.load();
        loadDataFromSystemIn.load();

        // thought out
        System.exit(OK_EXIT_STATUS);
    }

    protected static ConfigurableApplicationContext loadContext(
            final String contextPath) {
        final GenericApplicationContext ctx = new GenericApplicationContext();
        final XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(
                ctx);
        xmlReader.loadBeanDefinitions(new ClassPathResource(contextPath));
        final PropertyPlaceholderConfigurer placeholderProcessor = new PropertyPlaceholderConfigurer();
        ctx.addBeanFactoryPostProcessor(placeholderProcessor);
        ctx.refresh();
        return ctx;
    }
}
