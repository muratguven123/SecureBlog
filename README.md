README.md
Proje Hakkında
SecureBlog, Spring Boot ve JWT (JSON Web Token) kullanılarak hazırlanmış basit bir blog uygulamasıdır.
pom.xml dosyasında projenin amacı “JWT + Spring Security Blog Project” olarak tanımlanmıştır.
Ana uygulama sınıfı SecureBlogApplication içinde Spring Boot başlatılır

Temel Özellikler
JWT tabanlı kimlik doğrulama: JwtService sınıfı token oluşturma ve doğrulama işlemlerini yapar.

Spring Security yapılandırması: securityconfig sınıfı JWT filtresini sisteme ekleyip yetki kontrollerini ayarlar.

REST Controller’lar: Kullanıcı, yönetici, gönderi ve yorum işlemleri için ayrı controller sınıfları bulunur.

JPA Entity’leri: User, Post, Comment gibi modeller tanımlıdır.

Mapper sınıfları ve DTO’lar sayesinde entity–DTO dönüşümleri yapılır.

MySQL veritabanı kullanımı için gerekli ayarlar application.properties içinde örnek olarak verilmiştir:

spring.application.name=SecureBlog
pring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306
spring.datasource.username=root
spring.datasource.password=guven123.
spring.security.user.name=murat
spring.security.user.password=123

Kurulum
Java 17 ve Maven yüklü olmalıdır.

Gerekli veritabanı bilgilerini application.properties dosyasında güncelleyin.

Bağımlılıkların listesi pom.xml dosyasında yer alır. Temel bağımlılıklar arasında Spring Boot web, security, data‑jpa, validation, Auth0 JWT ve MySQL connector bulunmaktadır.

Çalıştırma
# Proje kök dizininde
./mvnw spring-boot:run
Uygulama varsayılan olarak http://localhost:8080 adresinde çalışır.

Testler
./mvnw test
Test klasörü altında temel örnek testler bulunur (örneğin UserMapperTest ve usercontrollertest).

API Hakkında Kısa Bilgi
/auth/** → Kayıt ve giriş işlemleri

/user/** → Kullanıcı işlemleri

/user/admin/** → Yöneticinin kullanıcı yönetimi

/post/** → Blog yazıları

/comment/** → Yorum işlemleri

Güvenlik katmanında JWT doğrulaması ve rol kontrolleri uygulanır.
