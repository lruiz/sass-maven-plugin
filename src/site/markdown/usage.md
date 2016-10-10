Usage
=====

Basic
-----
Add the plugin to your pom and run *mvn compile*, the default input directory is *src/main/sass*.

    <build>
        <plugins>
            <plugin>
                <groupId>org.tautua.maven.plugins</groupId>
                <artifactId>sass-maven-plugin</artifactId>
                <version>${LATEST}</version>
                <executions>
                    <execution>
                        <id>compile-sass</id>
                        <goals>
                            <goal>compile</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>


Full configuration
------------------
You can be more precise by specifying which version of sass or what others gems to include.

    <build>
        <plugins>
            <plugin>
                <groupId>org.tautua.maven.plugins</groupId>
                <artifactId>sass-maven-plugin</artifactId>
                <version>${LATEST}</version>
                <executions>
                    <execution>
                        <id>compile-sass</id>
                        <goals>
                            <goal>compile</goal>
                        </goals>
                    </execution>
                </executions>
                <configuration>
                    <rubygemsOptions>
                        <gems>
                            <gem>sass:3.4.22</gem>
                            <gem>susy:2.2.12</gem>
                        </gems>
                    </rubygemsOptions>
                    <sassOptions>
                        <input>src/test/sass</input>
                        <output>target/generated-test-sources/css</output>
                        <style>COMPRESSED</style>
                    </sassOptions>
                </configuration>
            </plugin>
        </plugins>
    </build>
