package com.offbit.cricexchange;

import com.offbit.cricexchange.config.AsyncSyncConfiguration;
import com.offbit.cricexchange.config.EmbeddedElasticsearch;
import com.offbit.cricexchange.config.EmbeddedKafka;
import com.offbit.cricexchange.config.EmbeddedRedis;
import com.offbit.cricexchange.config.EmbeddedSQL;
import com.offbit.cricexchange.config.TestSecurityConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { CricexchangeApp.class, AsyncSyncConfiguration.class, TestSecurityConfiguration.class })
@EmbeddedRedis
@EmbeddedElasticsearch
@EmbeddedSQL
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@EmbeddedKafka
public @interface IntegrationTest {
}
