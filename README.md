atom-log-boot-starter
==============
     log global MDC
     
## config
    1.add properties atom.log.key
    
## app config logback-spring
       
    <include resource="com/watent/log/base.xml"/> 
    com/watent/log the path of conf file
       
    <?xml version="1.0" encoding="UTF-8"?>
    <configuration>
        <springProperty scope="context" name="logging.file" source="logging.file"/>
        <springProperty scope="context" name="logging.path" source="logging.path"/>
        <springProperty scope="context" name="spring.application.name" source="spring.application.name"/>
        <property name="LOG_FILE" value="${logging.path:-.}/${logging.file:-${spring.application.name:-spring}.log}"/>
    
        <!--<include resource="org/springframework/boot/logging/logback/base.xml"/>-->
        <include resource="com/watent/log/base.xml"/>
        <jmxConfigurator/>
    
        <root level="INFO">
            <appender-ref ref="CONSOLE"/>
            <appender-ref ref="FILE"/>
        </root>
    
    </configuration>

    
    
    
    
    