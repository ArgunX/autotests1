FROM gradle:9.0.0-jdk17

WORKDIR /home/gradle/project

# Сначала копируем только то, что влияет на разрешение зависимостей (для кеша слоёв)
COPY --chown=gradle:gradle gradlew gradlew.bat settings.gradle build.gradle ./
COPY --chown=gradle:gradle gradle/wrapper gradle/wrapper

# На Windows `gradlew` часто с CRLF — исправляем, иначе /bin/sh ругнётся на ^M
RUN sed -i 's/\r$//' gradlew && chmod +x gradlew

# Прогреваем Gradle wrapper и кеш зависимостей
RUN ./gradlew --no-daemon -v && ./gradlew --no-daemon dependencies

# Теперь копируем исходники тестов
COPY --chown=gradle:gradle src ./src

CMD ["./gradlew", "--no-daemon", "test"]
