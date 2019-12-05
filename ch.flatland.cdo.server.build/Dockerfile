FROM maven:3-jdk-11 as builder

RUN mkdir -p /build

COPY ./ /build/
WORKDIR /build

RUN mvn -Pproduct-build clean package

FROM openjdk:11-jre-slim as runtime

COPY --from=builder /build/ch.flatland.cdo.server/target/products/ch.flatland.cdo.server-linux.gtk.x86_64.tar.gz /opt/cdo/bin/
COPY --from=builder /build/ch.flatland.cdo.server/x86_64/start.sh /opt/cdo/
COPY --from=builder /build/ch.flatland.cdo.server/x86_64/stop.sh /opt/cdo/
COPY --from=builder /build/ch.flatland.cdo.server/x86_64/config.json /opt/cdo/


RUN tar xvzf /opt/cdo/bin/ch.flatland.cdo.server-linux.gtk.x86_64.tar.gz -C /opt/cdo/bin/ 
RUN rm /opt/cdo/bin/ch.flatland.cdo.server-linux.gtk.x86_64.tar.gz


RUN chmod +x /opt/cdo/start.sh

EXPOSE 8199

CMD /opt/cdo/start.sh
