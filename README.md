# Human resource management system

Sistemimiz üç temel kullanıcı türüne sahiptir. Sistem personeli, İş Arayanlar ve İş verenler. Sistem personeli : Projenizde çalışan kişiler.

Req 1 : İş Arayanlar sisteme kayıt olabilmelidir.
Kabul Kriterleri:

Kayıt sırasında kullanıcıdan ad, soyad, tcno, doğum yılı, e-Posta, şifre, şifre tekrarı bilgileri istenir.
Tüm alanlar zorunludur. Kullanıcı bilgilendirilir.
Mernis doğrulaması yapılarak sisteme kayıt gerçekleştirilir.
Doğrulama geçerli değilse kullanıcı bilgilendirilir.
Daha önce kayıtlı bir e-posta veya tcno var ise kayıt gerçekleşmez. Kullanıcı bilgilendirilir.
Kayıdın gerçekleşmesi için e-posta doğrulaması gerekir.

Req 2 : İş verenler sisteme kayıt olabilmelidir.
Kabul Kriterleri:

Kayıt sırasında kullanıcıdan şirket adı, web sitesi, web sitesi ile aynı domaine sahip e-posta, telefon, şifre, şifre tekrarı bilgileri istenir. Burada amaç sisteme şirket olmayanların katılmasını engellemektir.
Tüm alanlar zorunludur. Kullanıcı bilgilendirilir.
Şirket kayıtları iki şekilde doğrulanır. Kayıdın gerçekleşmesi için e-posta doğrulaması gerekir. HRMS personelinin onayı gerekmektedir.
Daha önce kayıtlı bir e-posta var ise kayıt gerçekleşmez. Kullanıcı bilgilendirilir.

Req 3 : Sisteme genel iş pozisyonu isimleri eklenebilmelidir. Örneğin Software Developer, Software Architect.
Kabul Kriterleri:

Bu pozisyonlar tekrar edemez. Kullanıcı uyarılır.

Kurumsal Mimari:

<br>

![mm](https://user-images.githubusercontent.com/61664693/117733028-8a49d680-b1f9-11eb-9e88-d4950a59ca08.png)
