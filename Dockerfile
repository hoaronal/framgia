FROM selenium/node-firefox:3.141.59-mercury
LABEL authors=SeleniumHQ

USER seluser
COPY start-selenium-standalone.sh /opt/bin/start-selenium-standalone.sh
COPY selenium.conf /etc/supervisor/conf.d/

EXPOSE 4444