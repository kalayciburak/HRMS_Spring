## Human resource management system

#### <span style="color:#FF0048FF;">Req 1 : İş Arayanlar sisteme kayıt olabilmelidir.</span>

<ul style="color: #92c3ff">
    <li>Kayıt sırasında kullanıcıdan ad, soyad, tcno, doğum yılı, e-Posta, şifre, şifre tekrarı bilgileri istenir.</li>
    <li>Tüm alanlar zorunludur. Kullanıcı bilgilendirilir.</li>
    <li>Mernis doğrulaması yapılarak sisteme kayıt gerçekleştirilir.</li>
    <li>Doğrulama geçerli değilse kullanıcı bilgilendirilir.</li>
    <li>Daha önce kayıtlı bir e-posta veya tcno var ise kayıt gerçekleşmez. Kullanıcı bilgilendirilir.</li>
    <li>Kayıdın gerçekleşmesi için e-posta doğrulaması gerekir.</li>
</ul>

#### <span style="color:#FF0048FF;">Req 2 : İş verenler sisteme kayıt olabilmelidir.</span>

<ul style="color: #92c3ff">
    <li>Kayıt sırasında kullanıcıdan şirket adı, web sitesi, web sitesi ile aynı domaine sahip e-posta, telefon, şifre, şifre tekrarı bilgileri istenir. Burada amaç sisteme şirket olmayanların katılmasını engellemektir.</li>
    <li>Tüm alanlar zorunludur. Kullanıcı bilgilendirilir.</li>
    <li>Şirket kayıtları iki şekilde doğrulanır. Kayıdın gerçekleşmesi için e-posta doğrulaması gerekir. HRMS personelinin onayı gerekmektedir.</li>
    <li>Daha önce kayıtlı bir e-posta var ise kayıt gerçekleşmez. Kullanıcı bilgilendirilir.</li>
</ul>

#### <span style="color:#FF0048FF;">Req 3 : Sisteme genel iş pozisyonu isimleri eklenebilmelidir.</span>

<ul style="color: #92c3ff">
    <li>Bu pozisyonlar tekrar edemez. Kullanıcı uyarılır.</li>
</ul>

#### <span style="color:#FF0048FF;">Req 4 : İş verenler listelenebilmelidir. (Sadece tüm liste)</span>

#### <span style="color:#FF0048FF;">Req 5 : İş arayanlar listelenebilmelidir. (Sadece tüm liste)</span>

#### <span style="color:#FF0048FF;">Req 6 : İş pozisyonları listelenebilmelidir. (Sadece tüm liste)</span>

### <span style="color:#FF0048FF;">Req 7 : İş verenler sisteme iş ilanı ekleyebilmelidir.</span>

<ul style="color: #92c3ff">
    <li>İş ilanı formunda; Seçilebilir listeden (dropdown) genel iş pozisyonu seçilebilmelidir.(Örneğin Java Developer)(Zorunlu)</li>
    <li>İş tanımı girişi yapılabilmelidir. (Örneğin; firmamız için JAVA, C# vb. dillere hakim....)(Zorunlu)</li>
    <li>Şehir bilgisi açılır listeden seçilebilmelidir. (Zorunlu)</li>
    <li>Maaş skalası için min-max girişi yapılabilmelidir. (Opsiyonel)</li>
    <li>Açık pozisyon adedi girişi yapılabilmelidir. (Zorunlu)</li>
    <li>Son başvuru tarihi girişi yapılabilmelidir.</li>
</ul>

### <span style="color:#FF0048FF;">Req 8 : Sistemdeki tüm aktif iş ilanları listelenebilmelidir.</span>

<ul style="color: #92c3ff">
    <li>Liste, tablo formunda gelmelidir.</li>
    <li>Listede firmadı, genel iş pozisyonu adı, açık pozisyon adedi, yayın tarihi, son başvuru tarihi bilgileri olmalıdır.</li>
</ul>

### <span style="color:#FF0048FF;">Req 9 : Sistemdeki tüm aktif iş ilanları tarihe göre listelenebilmelidir.</span>

<ul style="color: #92c3ff">
    <li>Liste, tablo formunda gelmelidir.</li>
    <li>Listede firmadı, genel iş pozisyonu adı, açık pozisyon adedi, yayın tarihi, son başvuru tarihi bilgileri olmalıdır.</li>
</ul>

### <span style="color:#FF0048FF;">Req 10 : Sistemde bir firmaya ait tüm aktif iş ilanları listelenebilmelidir.</span>

<ul style="color: #92c3ff">
    <li>Liste, tablo formunda gelmelidir.</li>
    <li>Listede firmadı, genel iş pozisyonu adı, açık pozisyon adedi, yayın tarihi, son başvuru tarihi bilgileri olmalıdır.</li>
</ul>

### <span style="color:#FF0048FF;">Req 11 : İş verenler sistemdeki bir ilanı kapatabilmelidir.</span>

### <span style="color:#b453ff;">Kurumsal Mimari</span>

[comment]: <> (![mm]&#40;https://user-images.githubusercontent.com/61664693/117733028-8a49d680-b1f9-11eb-9e88-d4950a59ca08.png&#41;)
![Screenshot_5](https://user-images.githubusercontent.com/61664693/119628050-6c918980-be15-11eb-8a1c-2c35b97d406e.png)
