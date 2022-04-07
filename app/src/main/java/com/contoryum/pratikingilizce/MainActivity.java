package com.contoryum.pratikingilizce;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button bgeri,bileri,boku;
    TextView tvingkelime, tvtürk;
    TextToSpeech tt;
    int i=0;
    private AdView adView;
    private InterstitialAd mInterstitialAd;
    private int bannerIndex = 0;
    SharedPreferences p;

    String [] anlamveri={"Merhaba","Milimetre","Santimetre","Metre","Kilometre","Mil","Deniz Mili","Metre Kare","Kilometre Kare"
    ,"Hektar","Litre","Gram","Kilogram","Ton","Düzine","Pazartesi","Salı","Çarşamba","Perşembe","Cuma","Cumartesi","Pazar","Ocak"
    ,"Şubat","Mart","Nisan","Mayıs","Haziran","Temmuz","Ağustos","Eylül","Ekim","Kasım","Aralık","İlk Bahar","Yaz","Sonbahar","Kış"
    ,"Altın Rengi","Bej","Beyaz","Eflatun","Gri","Gümüş","Kahverengi","Kestane","Kırmızı","Lacivert","Mavi","Mor","Pembe","Sarı"
    ,"Siyah","Turuncu","Yeşil","Açık (Renk)","Gölgeli","Koyu (Renk)","Mat","Parlak (Renk)","Pastel (Renk)","Renkli","Renksiz","Soluk (Renk)"
    ,"Affedersiniz","Biliyorum","Bilmiyorum","Bir Dakika,Lütfen","Bir Şey Değil","Çok İyi","Çok Teşekkür Ederim","Dinle","Elbette"
    ,"Evet","Fena Değil","Güle Güle","Güzel","Harika","Hayır","Hoş Geldin","İmdat","Lütfen","Maalesef Olmaz","Memnuniyetle","Nefis"
    ,"Olamaz (Mümkün Değil)","Olmaz","Özür Dilerim","Pekala","Sahi mi?","Tabii","Tamam","Teşekkür Ederim","Yeter","Hangi(si)?"
    ,"Kaç Beden?","Kaç Para?","Kaç Tane?","Kaç Yaşında?","Kim?","Kimi,Kime?","Kimin?","Nasıl?","Ne?","Ne Çeşit?","Ne Kadar","Ne Kadar Ağır?"
    ,"Ne Kadar Uzak?","Ne Zaman?","Nerede?","Nereye?","Niçin?","Anlıyor Musunuz?","Beni Anlıyor Musunuz?","Anlıyorum","Sizi Anlıyorum"
    ,"Anlamıyorum","Sizi Anlamıyorum","Her Şeyi Anlıyorum","Tekrarlar Mısınız,Lütfen?","Lütfen yavaş konuşun","Konuşur musunuz?","İngilizce"
    ,"Türkçe","Almanca","Biraz ingilizce konuşurum","Hayır,İngilizce konuşamam","Bu ne demektir?","Yazabilir misiniz?"
    ,"Harflerini söylermisiniz?","Lütfen hatalarımı düzeltiniz","Bunu tercüme edebilir misiniz?","İngilizce öğrenmeye yeni başladım"
    ,"Biraz pratiğe ihtiyacım var","Adınız ne?","Benim adım","Tanıştığımıza sevindim","Memnun oldum","Sizi ...ile tanıştırayım"
    ,"Bu benim arkadaşım","Bu ...dır","Bay...","Bayan (Evli)","Bayan (Evli olmayan)","Benim kocam","Benim karım","Benim oğlum"
    ,"Benim kızım","Benim erkek kardeşim","Benim kız kardeşim","Soyadınız ne?","Soyadım ...dır","Merhaba","Günaydın","Tünaydın"
    ,"İyi akşamlar","İyi geceler","Ben bir öğrenciyim","Ankara'da oturuyorum","Bu otelde kalıyorum","Tatillerimi burada geçiririm"
    ,"İngiltere'nin neresindensiniz?","İngiliz misinz?","Nerelisiniz?","Kaç yaşındasınz?","Ne iş yapıyorsunuz?","Evli misiniz?","Evet,evliyim"
    ,"Bekarım","Çocuğunuz var mı?","...adında bir kızım (oğlum) var","Çocuğum yok","Karım bir hemşire (Ev kadını) dir"
    ,"Yolculuk yapmayı çok severim","Affedersiniz,...Hanım (Bey) evde mi?","Özür dilerim ...Hanım (Bey) burada mı oturuyor?","Hayır,taşındı"
    ,"Şimdi nerede oturduğunu biliyor musunuz?","Bayan (Bay) ...ile konuşabilir miyim?","Ne zaman evde olur?","Bir not bırakabilir miyim?"
    ,"Ben daha sonra gelirim","Lütfen içeri buyrun","Lütfen oturun","Sizi görmek ne hoş","Geldiğinize sevindim","Paltonuzu alayım"
    ,"Ne alırdınız?","Size ne ikram edebilirim?","Akşam yemeğine kalmaz mıydınız?","Özür dilerim ama gitmem gerek","Ziyaretiniz için teşekkürler"
    ,"Sizin uyruğunuz ne?","Türküm","Onun uyruğu ne?","Nerelisiniz?","İngilizim (Fransızım)","Onlar nereli?","Sağ olun","Yardımnız için teşekkür ederim"
    ,"Teşekkürler, çok yardımseversiniz","Çok naziksiniz","Her şey için teşekkürler","Bana bir ... verebilir misiniz,lütfen?","Sizi rahatsız ettiğim için özür dilerim"
    ,"Lütfen bana yolu gösteriniz","Kapıyı kapar mısınız,lütfen?","Bana bir iyilikte bulunabilir misiniz?","Müsaade eder misiniz?","Ne arzu edersiniz?"
    ,"...nin nerede olduğunu söyleyebilir misiniz?","Ne istiyorsunuz?","Bir paket şeker istiyorum","...ister misiniz?","... yı uzatabilir misiniz,lütfen?"
    ,"Hiç bir şey istemiyorum","Bir telefon edebilir miyim?","Faks çekebilir miyim?","Nereden kontör kartı alabilirim?","Kontörlü telefon var mı?"
    ,"Nerede bir internet cafe bulabilirim?","Maillerimi okumak istiyorum","Nasıl bir mail gönderebilirim?","Telefon kartı bulabilir miyim?"
    ,"Cep telefonunuzu kullanabilir miyim?","Size bir soru sorabilir miyim?","...yı gösterebilir misiniz?","Aldırma (Boş ver)","Özür dilerim","Pardon"
    ,"Efendim?(Ne dediniz?)","Sizi kırmak istememiştim","Benim hatam","Bir daha olmaz,özür dilerim","Fark etmez","Rica ederim","Rahatsız ettiğim için özür dilerim"
    ,"Bol şanslar","Geçmiş olsun","Mutlu yıllar","Doğum günün kutlu olsun","En iyi dileklerimle","Tebrikler","İyi günler","İyi tatiller","İyi yolculuklar"
    ,"...yı seviyor musunuz?","...hakkında ne düşünüyorsunuz?","...yı nasıl buluyorsunuz?","Bunu sevdim","Bunu sevmedim","Bunu tercih ederim"
    ,"Fotbulu çok severim","Çikolataya pek düşkün değilim","Operayı pek sevmem","Tabi","iyi olur","Memnuniyetle","İyi","Çok isterim","İstemiyorum"
    ,"Canım istemiyor","Tamam","Pekiyi","Oldu","Olamaz","Mümkün değil","Asla","Henüz bilmiyorum","Sizinle tamamen hemfikirim","Aynı fikirde değilim"
    ,"Anlaştık","Belki","Olabilir","Güle Güle","Görüşürüz","Görüşmek üzere","Geldiğiniz için teşekkürler","Yine buyrun","Hoşça kal","Kendine iyi bak"
    ,"Bay bay","Yakında görüşürüz","Sonra görüşürüz","Pazartesi (cuma ...) görüşürüz","Tekrar ne zaman görüşeceğiz?","Sizi eve bırakayım","Seni özleyeceğim"
    ,"Yarın (öbür gün,cumartesi günü) görüşebilir miyiz?","Rezervasyonum var","Bir oda ayırtmıştım","Selin adına bir oda ayırtmıştım","Boş odanız var mı?"
    ,"Tek kişilik bir oda istiyorum","Bir gece için çift kişilik bir oda istiyorum","İki yataklı (duşlu, telefonlu) bir oda istiyorum","Odayı görebilir miyim?"
    ,"Odayı gösterir misiniz?","Çok büyük(Küçük,karanlık,gürültülü,pahalı)","Daha büyük (sıcak,ucuz) bir odanız var mı?","Bir geceliği ne kadar?"
    ,"Bir günlüğü (Haftalığı) ne kadar?","Tam pansiyon ne kadar?","Kahvaltı (her şey) dahil mi?","Ekstra masraflar var mı?","Asansör var mı?"
    ,"Lokantanız (garajınız) var mı?","Kahvaltı ne zaman?","Restoran kaçıncı katta?","Kahvaltımı odamda yapabilir miyim?","Otel kaçta kapanıyor?"
    ,"Eşyam var","Eşyalarım arabada","Eşyalarımı odama getirir misin?","Eşyalarımı lütfen aşağıya indiriniz?","Size yardımcı olabilir miyim?","Boş odamız yok"
    ,"Oda ayırtmış mıydınız?","Bir dakika lütfen","Nasıl bir oda arzu edersiniz?","Su yok","Tuvalet kağıdı yok","Musluk damlıyor","Pencereyi açamıyorum"
    ,"Çarşaflar temiz değil","Havlular kirli","Odayı temizler misiniz?","Çarşafları (havluları) değiştirir misiniz?","Anahtar kapatmıyor","Kalorifer çalışmıyor"
    ,"Bu akşam ayrılıyorum","Yarın saat 8'de ayrılacağız","Ne zamana kadar odayı boşaltmamız gerekiyor?","Hesabım hazır mı?","Hesabı rica edecektim"
    ,"Kredi kartı ile ödeyebilir miyim?","Seyahat çeki alıyor musunuz?","Yabancı para alıyor musunuz?","Eşyalarımı aşağıya indirtir misiniz?"
    ,"Taksi çağırır mısınız?","Sizi birisi görmek istiyor","Size telefon (mektup,kart,not) var","Size telefon var","Lütfen beni saat 8'de uyandırın"
    ,"Sabun alabilir miyim?","Bir kaç askı getirir misiniz?","Bir battaniye daha alabilir miyim?","Lütfen birkaç havlu getiriniz","Benim için mektıp (mesaj) var mı?"
    ,"Bir arkadaşımı bekliyorum","Gelince bana haber verebilir misiniz?","Mektup (Telefon) bekliyorum","Buradan telefon edebilir miyim?","Beni arayan soran oldu mu?"
    ,"Oda numaranız kaç?","Odanıza servis ister misiniz?","Sizi sabahleyin uyandırmamı ister misiniz?","Sabahleyin gazete ister misiniz?"
    ,"Günlüğü ...lira","Şurayı imzalayın lütfen","Eşyanız var mı?","Oda numaraız 105","Her şey dahil ...lira","Asansör solda (sağda)","Odanız beşinci katta"
    ,"Lokanta zemin katta","Kahvaltı saat 8'de","Akşam yemeği saat altından ona kadar","Restoranımızda fiks menü var","Hesabınız hazır","İşte hesabınız"
    ,"Taksi çağırayım mı?","Taksi çağırmamı ister misin?","Kamp yeri arıyoruz","Burada kamp yapabileceğimiz bir yer var mı?","En yakın kamping nerede?"
    ,"...camping nerede?","Burada kamp yapabilir miyim?","Çadırımızı nerede kurabiliriz?","Çadır için yeriniz var mı?","Karavanımızı buraya koyabilir miyiz?"
    ,"İki (üç...) kişiyiz","Duş (tuvalet) var mı?","Kamp yerinde dükkan(bar...) var mı?","Duş alabilir miyim?","Ateş yakabilir miyim?","İçme suyu var mı?"
    ,"Tuvalet nerede?","Bulaşıklarımızı nerede yıkayabiliriz?","Çöpü nereye dökebilirim?","Çadır yeri (karavan yeri) var mı?","Nereden buz satın alabiliriz?"
    ,"Çadır (karavan) ne kadar?","Adam başı ne kadar?","Dolar(Sterlin..) bozabilir misin?","Yarın sabah ayrılıyorum","Açılış saatleri","Açık","Kapalı"
    ,"Tatil için kapalı","Ne zaman açıyorsunuz?","Ne zaman kapıyorsunuz?","...nerede satılır?","Nereden .... bulabilirim?","Alışveriş merkezi nerede?"
    ,"Bana bir... dükkan tavsiye edebilir misiniz?","Yardımcı olur musunuz?","Ne arzu edersiniz?","Nasıl çalıştığını gösterebilir misiniz?","Size servis yapılıyor mu?"
    ,"Teşekkür ederim,sadece bakıyordum?","-e ihtiyacım var","... rica ediyorum","Kaç tane istiyorsunuz?","Ne kadar istiyorsunuz?","Bunlardan başka var mı?"
    ,"Şunlardan bir tane istiyorum","Onu sevmedim","Sizde... var mı?","... ya bir bakabilir miyim lütfen?","Vitrindeki ...yi görebilir miyim?"
    ,"Bana bir başka... gösterebilir misiniz?","Bu benim için çok fazla","Yeterli param yok","Daha ucuzu var mı?","Ne kadar indirim yapabilirsiniz?"
    ,"Taksitle ödeyebilir miyim?","Bu hoşuma gitti.Alıyorum","Kasa nerede?","Nered bir fırın(Kasap) bulabilirim?","Ne istiyordunuz?","...rica ediyorum"
    ,"Bir kilo...","Bir şişe...","Bir paket...","Bir kutu...","Bir parça...","Beş dilim...","Bunu deneyebilir miyim?","Başka bir şey?","Hayır,sağ olun.Hepsi bu kadar"
    ,"Bir paket... sigaras,lütfen","Bir karton... sigarası, lütfen","Sizde sigara bulunur mu?","Bir paket pipo tütünü,lütfen","İki puro,lütfen","Bir çakmak,lütfen"
    ,"Bana bir... gösterebilir misiniz?","Elbise","Gömlek","Ceket","Bluz","Kokteyl parti için bir şey istiyorum","Lütfen bir kaç ipek gömlek gösterebilir misiniz?"
    ,"Kumaşı nedir?","Hangi renk olsun?","Bir tane...renk istiyorum","Maviyi tercih ederim","Onu gün ışığında görebilir miyim?","Oradakini beğendim"
    ,"Vitrindekini beğendim","Buna uygun bir şey istiyorum","Bunu deneyebilir miyim?","Bir ayna istiyorum","Kaç beden giyiyorsunuz?","Bedenim Avrupa ölçülerine göre 40"
    ,"O çok...","Dar","Kısa","Uzun","Küçük","Büyük","Daha küçüğü var mı?","Daha büyüğü var mı?","Rengi hoşuma gitmedi","Biçimi hoşuma gitmedi","Başka renkleri var mı?"
    ,"Yıkanabilir mi?","Çeker mi?","Bu tam istediğim gibi değil","Fermuarlı olanı istiyorum","Kollar çok uzun","Kollar çok kısa","Bu bana yakışmadı"
    ,"Başka bir şeyiniz var mı?","Bu iyi uydu.Alıyorum","Hepsi ne kadar tutuyor?","Bir çift... istiyorum","...numara","Ne renk istiyorsunuz?","Bunlar çok dar"
    ,"Bunlar çok bol","Burası sıkıyor","Biçimi hoşuma gitmedi","Oradakini beğendim","Vitrindekini beğendim","Bu modelin siyahı var mı?","Daha büyük boyu var mı?"
    ,"Hangi malzemeden yapılmış?","Bu ayakkabıları tamir edebilir misiniz?","Bir kutu ayakkabı boyası,lütfen","Bu ayakkabıya yeni pençe yaptırmak istiyorum"
    ,"Topukları yeniler misiniz,lütfen?","Çocuk ayakkabısı satıyor musunuz?","Bir ...istiyorum","Kartpostal var mı?","Bir kaç zarf istiyorum"
    ,"Bir tükenmez kalem istiyorum","İngilizce kitaplar hangi rafta?","Türkçe gazete satıyor musunuz?","Nereden gazete alabilirim?","...tanıtan bir rehber kitap istiyorum"
    ,"Bir Türkiye haritası istiyorum","Vesikalık resim çektirmek istiyorum","...tane fotoğraf ne kadar?","Resimleri ne zaman alabilirim?","...rica ediyorum"
    ,"Bu makine için bir film","36 pozluk bir film","Lütfen,filmi takar mısınız?","Bu filmin banyosunu yapar mısınız?","Her pozdan... tane rica ediyorum"
    ,"Hangi ebatta?","18x24","Parlak mı, mat mı?","Fotoğraflar ne zaman hazır olur?","Bunu büyütmek istiyorum","Bir flaş lambası istiyorum","Flaş için pil istiyorum"
    ,"Bu fotoğraf makinesini tamir edebilir misiniz?","Film sıkışmış","Şu saate bakabilir miyim?","Bir kol saati satın almak istiyorum","Bu saati tamir edebilir misiniz?"
    ,"Saatim çalışmıyor","Saatim aniden durdu","Bu saat ileri gidiyor","Bu saat geriye kalıyor","Tamir masrafı ne kadar olacak?","Ne zaman hazır olur?"
    ,"Bir ...satın almak istiyorum","Bilezik","Yüzük","Kaç ayar?","Kaç gram?","18 Ayar bir altın yüzük istiyorum","Gümüş eşya koleksiyoncusuyum"
    ,"Bu hakiki gümüş mü?","Bu altın / gümüş kaplama mı?","...için bir hediye arıyorum","Kızım","Oğlum","Karım","Kocam","...için uygun bir şey var mı?"
    ,"İlginç bir şeyiniz var mı?","Bir şey önerebilir misiniz?","El yapımı bir şeyiniz var mı?","Yöresel bir şeyiniz var mı?","Bu gözlüğü tamir edebilir misiniz?"
    ,"Gözlüğümün bir camı kırıldı","Gözlüğünüz kaç derece?","Ben miyobum","Ben hipermetrobum","Gözlüğü ne zaman alabilirim?","...günün için bir randevu alabilir miyim?"
    ,"Acelem var","Saçınızın nasıl olmasını isterdiniz?","Yıkanıp fön çekilecek","Yıkayıp kesin,lütfen","Perma istiyorum","Saçımı boyatmak istiyorum"
    ,"Röfle yaptırmak istiyorum","Saçımı kestirmek istiyorum","Nasıl bir mode istiyorsunuz?","Kısa bir saç modeli istiyorum","Lütfen biraz uçlarından alın"
    ,"Biraz daha kısa kesebilir misiniz?","Yanlardan biraz alır mısınız?","Üstten geriye tarar mısınız?","Yukarıda toplar mısınız,lütfen?","Uzun bırakın lütfen"
    ,"Çok kısa olmasın","Önden biraz daha alın,lütfen","Yanlardan biraz daha alın,lütfen","Sprey istemiyorum","Manikür yapar mısınız,lütfen?"
    ,"Pedikür yapar mısınız,lütfen?","Kaşlarımı düzeltir misiniz?","Saç traşı olmak istiyorum","Çok kısa olmasın","Uzun bırakın,lütfen","Kulaklar açık kalsın"
    ,"Sağdan ayırın","Soldan ayırın","Biraz daha kısa kesebilir misiniz?","Yanlardan biraz alır mısınız?","Lütfen sadece uçlarından alın"
    ,"Üstten geriye tarar mısnız?","Çok sprey sıkmayın","Bir ustura tıraşı,lütfen","Bir sakal tıraşı,lütfen","Sakalımı düzeltin,lütfen"
    ,"Buralarda... var mı?","İyi bir lokanta","Yöresel yemekli lokanta","Bir japon lokantası","Bir İtalyan lokantası","Pahalı olmayan bir lokanta"
    ,"Saat... için iki kişilik bir masa ayırır mısınız?","Rezervasyon kimin için olacak?","Bay... adına","...adına bir masa ayırtmıştım"
    ,"Bu bir iş yemeği","Saat kaç için?","Maalesef bu akşam doluyuz","Rezervasyonunuz var mı?","Beni takip ediniz, lütfen","Bu masa boş mu?"
    ,"İki kişilik bir masa, lütfen","Üç kişilik bir masa, lütfen","Pencere kenarında bir masa istiyoruz","Bu masa iyi mi?","Size yemek listesini getireyim"
    ,"Garson! Menüyü alabilir miyim,lütfen?","Siparişinizi alabilir miyim?","Ne tavsiye edersiniz?","-yı tavsiye edebilirim","Bugünün özel yemeği.. dir"
    ,"Ne alırdınız?","Çocuklar için yarım porsiyon yapıyor muydunuz?","Siparişe hazır mısınız?","Çorba ile başlayacağız","Meze olarak ne alacaksınız?"
    ,"Meze istemiyorum,sağ olun","Ana yemek olarak ne alacaksınız?","Ben... alacağım","Karışık ızgara","Kuzu çevirme","Izgara köfte","Balık","Maalesef... kalmadı"
    ,"...yerine... alabilir miyim?","...ya alerjim var","Bifteğinizi nasıl isterdiniz?","İyi pişmiş","Orta pişmiş","Çok az pişmiş","Salata alır mıydınız?"
    ,"Ne içmek isterdiniz?","Şarap listesini görebilir miyim?","Bir bardak... lütfen","Buz ile,lütfen","Tatlı alacağım","Tatlı olarak neyiniz var?"
    ,"Bize... getirin,lütfen","Biraz daha ekmek alabilir miyim?","Biraz daha su alabilir miyim?","Bize bir... getirebilir misiniz?","Çatal","Bıçak"
    ,"Kaşık","Bardak","Bu yemeğin adı ne?","Buyurun?","Şerefe","...nın sağlığına","Bana ...yı uzatabilir misiniz lütfen","Biraz daha... alır mıydınız?"
    ,"Hayır,teşekkür ederim.Yeterince aldım","Sağ olun,doydum","Başka bir şey istemiyorum,teşekkürler;sadece kahve","Sigara içmem sizi rahatsız eder mi?"
    ,"Yemeği beğendiniz mi?","Mükemmeldi","Davet için çok teşekkür ederim","Bu...değil","Temiz","Soğuk","Taze","Sıcak","Benim ...mı unuttunuz mu?"
    ,"Bu (çok) ...","Bayat","Tatlı","Tuzlu","Ekşi","Acılı (Baharatlı)","Sert","Ben bunu ısmarlamadım","Geri götürün,lütfen","Hesap,lütfen"
    ,"Hesabı alabilir miyim.lütfen?","Hesaplar ayrı olsun,lütfen","(Hesaplar) birlikte olsun,lütfen","Servis dahil mi?","Sanırım hesap yanlış"
    ,"Hesap çok fazla","Yemek hoşunuza gitti mi?","Yemek çok güzeldi","Bu sizin için","Üstü kalsın","Buralarda iyi bir pub var mı?","Nerede caz müziği dinleyebilirim?"
    ,"Nerede dans edebiliriz?","Giriş ücretine bir içki dahil","Bir viski-soda,lütfen","Aynısından bir tane daha","Bu içkiler benden","Bir tur atalım mı?"
    ,"Yanınıza oturabilir miyim?","Dans edelim mi?","Çok iyi dans ediyorsunuz","Eğleniyor musunuz?","Eğlenmenize bakın","Tekrar ne zaman görüşebiliriz?"
    ,"Bu güzel akşam için teşekkürler"};


    String [] ingveri={"Hello","Millimetre","Centimetre","Metre","Kilometre","Mile","Nautical Mile","Square Metre","Square Kilometre"
    ,"Hectare","Litre","Gram","Kilogram","Ton","Dozen","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday","January"
    ,"February","March","April","May","June","July","August","September","October","November","December","Spring","Summer","Autumn","Winter"
    ,"Golden","Beige","White","Violet","Grey","Silver","Brown","Chestnut","Red","Navy Blue","Blue","Purple","Pink","Yellow","Black"
    ,"Orange","Green","Light (Colour)","Shaded","Dark (Colour)","Mat","Bright (Colour)","Pastel (Colour)","Coloured","Colourless"
    ,"Pale (Colour)","Excuse Me","I Know","I Don't Know","Just A Minute,Please","Not At All","Very Good","Thank You Very Much","Listen"
    ,"Certainly","Yes","Not Bad","Good-Bye","Good","Wonderful","No","Welcome","Help","Please","I'm Sorry(I Can't)","With Pleasure"
    ,"Delicious","Impossible","Not Possible","I'm Sorry","All Right","Really?","Of Course","Okay","Thank You","That's Enough","Which?"
    ,"What Size?","How Much?","How Many?","How Old?","Who?","Whom?","Whose?","How?","What?","What Kind?","How Much?","How Heavy","How Far?"
    ,"When?","Where?","Where to?","Why?","Do You Understand?","Do You Understand Me?","I Understand","I Understand You","I Don't Understand"
    ,"I Don't Understand You","I understand everything","Would you repeat that,please?","Please speak slowly","Do you speak?","English"
    ,"Turkish","German","Speak English a little","No,I don't speak English","What does this mean?","Can you write it down?","Can you spell it?"
    ,"Please correct my mistakes","Can you translate this","I have just started learning English","I need some practice","What's your name?"
    ,"My name's...","Nice to meet you","How do you do","Let me introduce you to ...?","This is my friend","This is...","Mr....","Mrs. ..."
    ,"Miss...","My husband","My wife","My son","My daughter","My brother","My sister","What's your surname?","My surname's...","Hi"
    ,"Good morning","Good afternoon","Good evening","Good night","I'm a student","I live in Ankara","I'm staying in this hotel"
    ,"I spend my holidays here","Where in England are you from?","Are you English?","Where are you from?","How old are you?","What do you do?"
    ,"Are you married","Yes,I'm married","I'm single","Have you got any children?","I've got daughter (son) called...","I haven't got any children"
    ,"My wife is a nurse (house-wife)...","I like travelling very much","Excuse me,is Mrs. (Mr) ...at home?","Excuse me,does Mrs. (Mr.) live here?"
    ,"No,he's (She's) moved","Do you know where he's (she's) living now?","Can I speak to Mrs.(Mr.)...,please?","When will he (she) be home?"
    ,"Can I leave a message?","I'll come back later","Come in,please","Please sit down","How nice to see you","I'm glad you could come"
    ,"Let me take your coat","What would you like?","What can I offer you?","Wouldn't you like to stay for dinner?","I'm sorry but I have to go"
    ,"Thank you for your visit","What is your nationality?","I'm Turkish","What is his nationality?","Where are you from?","I'm from England(France)"
    ,"Where do they come from?","Thank you","Thank you for your help","Thank you,It's very kind of you to help","It's very kind of you"
    ,"Thanks for everything","Can you give me a ...please","I am sorry to trouble you","Please show me the way","Will you shut the door,please?"
    ,"Could you do me a favour","Excuse me?","What would you like?","Could you tell me where ...is?","What do you want?","I want a packet of sugar"
    ,"Do you want ...?","Can you pass the ... please?","I don't want anything","Can I make a telephone call?","May I send a fax?","Where can I get a phonecard?"
    ,"Is there a public telephone?","Where can I find an internet cafe?","I want to read e-mails","How can I send an e-mail?","Can I find a phonecard?"
    ,"May I use your mobile phone?","Can I ask you question?","Can you show ...?","Never mind","I'm sorry","Pardon","I beg your pardon?"
    ,"I didn't mean you hurt you","My mistake","Sorry,It won't happen again","It doesn't matter","That's all right","Sorry to trouble you"
    ,"Good luck","Get well soon","Happy new year","Happy birthday","With my best wishes","Congratulations","Have a nice day","Have a nice holiday"
    ,"Have a nice journey","Do you like ...?","What do you think of ...?","How do you like ...?","I like this","I don't like this","I'd prefer this"
    ,"I'm very keen on football","I'm not very fond of chocolate","I don't care much for opera","Of course","That would be nice","With pleasure"
    ,"Good","I'd love to","I don't want to","I don't feel like it","All right","All right","Okay","No","Impossible","Never","I don't know yet"
    ,"I quite agree with you","I don't agree","Agreed","Perhaps","Maybe","Goodbye","See you","So long","Thank you for coming","Come again soon","So long"
    ,"Take care of yourself","Bye bye","See you soon","See you later","See you on Monday (Friday ...)","When shall we meet again?","Let me drive you home"
    ,"I'll miss you","Can we meet (the day after tomorrow,Saturday tomorrow?)","I've reservation","I've reserved a room","I've booked a room in the name of selin"
    ,"Have you any vacant rooms?","I'd like a single room","I'd like a double room one night","I'd like a room with twin beds (a shower,a phone)"
    ,"Can I see the room?","Can you show me the room?","It's to big (small,dark,noisy,expensive)","Have you a bigger (warmer,cheaper) room?"
    ,"How much is it for one night?","How much is it per day (week)?","How much is it for full board?","Is breakfast (everything) included?"
    ,"Is there any extra charge?","Is there a lift?","Do you have a restaurant (garage)?","What time is breakfast?","Which floor is the restaurant on?"
    ,"Can I have breakfast in my room?","What time does the hotel close?","I've got some luggage","My luggage is in the car","Could you bring my luggage to my room?"
    ,"Have my luggage taken downstairs, please","Can I help you?","We have no room","Have you booked a room?","One moment please","What kind of accommodation do you want?"
    ,"There's no water","There's no toilet paper","The tap drips","I can not open the window","The sheets aren't clean","The towels are dirty"
    ,"Can you clean the room?","Can you change the sheets (towels)?","The key doesn't lock","The heating doesn't work","I'm leaving this evening"
    ,"We shall be leaving at eight o'clock","By what time do we have to vacate the room?","Is my bill ready?","I would like the bill,please"
    ,"Can I pay by credit card?","Do you accept traveller's cheques?","Do you take foreign money?","Could you have my luggage brought down?"
    ,"Could you call a taxi?","Someone wants to see you","There's a call (letter,card,message) for you","There's a call for you","Please call me at eight o'clock"
    ,"Can I have some soap?","Can you bring me some hangers?","Can I have another blanket?","Please bring some towels","Are there any letters (messages) for me?"
    ,"I'm waiting for a friend","Could you call me when he arrives?","I'm waiting for a letter (phone)","Can I make a telephone call from here?"
    ,"Did anyone ask for me?","What's your room number?","Would you like room service?","Would you like an early call?","Would you like a morning paper?"
    ,"It costs ... liras a day","Please sign here","Have you got any luggage?","Your room number is hundred five","It's ...lira altogether"
    ,"The lift is on the left (right)","Your room is on the fifth floor","The restaurant is on the ground floor","The breakfast is at 8 o'clock"
    ,"Dinner is from six to ten o'clock","The restaurant has a table d'hote menu","Your bill is ready","Here's your bill","Shall I call a taxi?"
    ,"Would you like me to call a taxi?","We're looking for a camping site","Is there anywhere for us to camp near here?","Where's the nearest camping ground?"
    ,"Where's ... camping ground?","Can I camp here?","Where can we pitch our tent?","Have you got a site for our tent?","May we park our caravan here?"
    ,"There are two (three ...) of us","Are there any showers (toilet)?","Is there a shop(bar...) on the site?","Can I have a shower?","Can I light a fire?"
    ,"Is there any drinking water?","Where is the toilet?","Where can we wash our dishes?","Where do I dispose of rubbish?","Are there any tent sites(caravan sites)?"
    ,"Where can we buy ice?","How much is it for a tent(caravan)?","How much is it per person?","Can you change the dollars (pounds..)?","I'm leaving tomorrow morning"
    ,"Opening hours","Open","Closed","Closed for holidays","When do you open?","When do you close?","Where do they self ...?","Where can I find ...?"
    ,"Where's the main shopping area?","Can you recommend a... shop?","Can you help me please?","What would you like?","Can you show me how it works?"
    ,"Are you being served?","Thank you,I'm just looking round","I need...","I'd like...","How many do you want?","How much do you want?"
    ,"Do you have more of these?","I want one of these","I don't like it","Have you got...?","Could I have a look... please?","Can I see the...in the window?"
    ,"Could you show me another...?","That's too much for me,","I don't have enough money","Have you anything cheaper?","Have much of a discount can you give me?"
    ,"Can I pay in instalments?","I like this.I'll take it","Wheres the cashier?","Where can I find a baker (butcher)?","What would you like?","I'd like..."
    ,"a kilo of...","A bottle of...","a packet of...","a tin of...","a piece of...","five slice of...","Could I try this?","Anything else?","No,thank you.That's all"
    ,"A packet of... cigarettes,please","A box of... cigarettes,please","Have you got cigarettes?","A packet of pipe tobacco,please","Two cigars,please"
    ,"A lighter,please","Can show me a...?","Dress","Shirt","Jacket","Blouse","I would like something for a cocktail party","Can you please show me some silk shirts?"
    ,"What is the material?","Have you got a particular colour in mind?","I'd like something in...","I prefer the blue one","My I see it in the daylight?"
    ,"I like that one there","I like the one in the window","I'd like something to match this","Can I try it one?","I would like a mirror","What size do you wear?"
    ,"I take a continental size 40","İt is too...","Tight","Short","Long","Small","big","Have you got a smaller one?","Have you got a larger one?"
    ,"I don't like the colour","I don't like the shape","Have you got it in other colours?","Is it washable?","Will it shrink?","It's not quite what I wanted"
    ,"I'd like the one with a zip","The sleeves are too long","The sleeves are too short","It doesn't suit me","Do you have anything else?","It's a good fit.I'll take it"
    ,"How much is it altogether?","I'd like a pair of...","Size..","What colour do you want?","These are too narrow","These are too wide","They pinch me here"
    ,"I don't like the shape","I like that one there","I like the one in the window","Do you have this model in black?","Have you got a larger size?"
    ,"What's the material?","Can you repair these shoes?","A tube of shoe cream,please","I'd like to have new soles put on these shoes","Could you put new heels on,please?"
    ,"Do you sell children's shoes?","I want a...","Have you any postcards?","I would like some envelopes","I would like a ballpoint pen","where do you keep the English books?"
    ,"Do you sell Turkish newspapers?","Where can I buy a newspaper?","I want a guide to...","I want a map of Turkey","I want to have a passport picture taken"
    ,"How much are ... photos?","When can I get the pictures?","I'd like...","A film for this camera","A film with 36 exposures","Could you put the film,please?"
    ,"Would you develop this film,please?","I want... prints of each negative","What size?","Eighteen by twenty-four","Gloss or mat?","When will the photographs be ready?"
    ,"I would like this print enlarged","I want a flash bulb","I want batteries for the flash","Can you repair this camera?","The film is jammed"
    ,"Can I see that watch?","I want to by a watch","Can you repair this watch?","My watch doesn't work","My watch stopped suddenly","This watch is fast"
    ,"This watch is slow","How much will the repair cost?","When will it be ready?","I want to buy a...","Bracelet","Ring","How many carats?","How many grams?"
    ,"I want an 18 carat gold ring","I'm a collector of silverware","Is this real silver?","Is it gold / silver plated?","I'm looking for a present for..."
    ,"My daughter","My son","My wife","My husband","Have you got anything for...?","Have you got anything interesting?","Can you suggest anything?"
    ,"Do you have something hand-made?","Have you got anything made locality?","Can you repair these glasses?","One of the lenses of my glasses is broken"
    ,"What's your acuity?","I'm short-sighted","I'm farsighted","When can I pick up the glasses?","Can I make an appointment for...?","I'm in a hurry"
    ,"How would you like your hair done?","Shampoo and blow dry","Wash and cut, please","I'd like a perm","I want my hair dyed","I want to have my hair high lighted"
    ,"I'd like to have my hair cut","What style do you want?","I'd like a short hair style","Just trim the ends,please","Could you cut it a bit-shorter,please?"
    ,"Could you thin out the sides a little?","Would you back comb it on top?","Would you pin it up,please?","Leave it long,please","Not too short"
    ,"A bit more off the front,please","A bit more off the sides,please","No hair sprey","Can you give me a manicure,please?","Can you give me a pedicure,please?"
    ,"Could you tidy up my eyebrows?","I want to have a haircut","Not too short","Leave it long,please","Cut above the ears","The parting on the right"
    ,"The parting on the left","Could you cut it a bit shorter,please?","Could you thin out the sides a little?","Just trim the ends,please"
    ,"Would you back comb it on top?","Not too much hair spray","A razor curt,please","I'd like a shave,please","Would you trim my beard,please?"
    ,"Is there... near here?","A good restaurant","A restaurant with local specialities","A Japanese restaurant","A Italian restaurant","An inexpensive restaurant"
    ,"Will you reserve a table for two for... o'clock?","Who's the reservation for?","For Mr. ...","I have reserved a table in the name of..."
    ,"This is for a business lunch","For what time?","Sorry,we're full this evening","Have you got a reservation?","Follow me,please","Is this table free?"
    ,"A table for two,please","A table for three,please","We want a table near the window","Will this table be all right?","I'll bring you the menu"
    ,"Waiter! Can I have the menu,please?","Can I take your order?","What do you recommend?","I can recommend..."
    ,"Today's special is...","What would you like?","Do you half portion for children?","Are you ready to order?","We'll begin with soup","What would you like as a starter?"
    ,"I don't want a starter,thank you","What would you like as a main course?","I'll have...","Mixed grill","Roast lamb","Grilled meatballs"
    ,"Fish","I'm sorry.there isn't... left","Could I have... instead of...?","I'm allergic to...","How would you like your steak?","Well done"
    ,"Medium","Rare","Would you like a salad?","What would you like a drink?","May I see the wine list","A glass of... please","With ice, please"
    ,"I'll have a dessert","What do you have for dessert?","Bring use...please","Could we have some more bread?","Could we have some more water?"
    ,"Could you get us a...?","Fork","Knife","Spoon","Glass","What's this dish called?","Help yourself?","Cheers","To the health of...","Could you pass me the...please?"
    ,"Would you like some more...?","No,thank you.I've had enough","I'm full,thank you","Nothing else,thanks;just coffee","Do you mind, if I smoke?"
    ,"Did you enjoy the meal?","It was excellent","Thank you very much for the invitation","This isn't...","Clean","Cold","Fresh","Hot","Have you forgotten my...?"
    ,"This is (very)...","Stale","Sweet","Salty","Sour","Hot (Spicy)","Tough","I didn't order that","Take it back,please","The bill,please","Could I have the bill,please?"
    ,"Separate bills,please","(Bills)All together,please","Is service included?","I thing the bill is wrong","The bill is too much","Did you enjoy your meal?"
    ,"The food was excellent","This is for you","Keep the change","Is there a nice pub here?","Where can I hear jazz music?","Where can we go dancing?"
    ,"One drink is included in the price of admission","A whisky and soda,please","The same again","This round's on me","Shall we go for a walk?"
    ,"May I sit near you?","Shall we dance?","You dance very well","Are you enjoying yourself?","Enjoy yourself","When can we meet again?"
    ,"Thank you for this pleasant evening"};





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p=PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        i=p.getInt("a",0);

        bgeri = (Button) findViewById(R.id.btngeri);
        bileri = (Button) findViewById(R.id.btnileri);
        boku = (Button) findViewById(R.id.btnoku);

        //reklamiYukle();

        tvingkelime = (TextView) findViewById(R.id.textingilizce);
        tvtürk = (TextView) findViewById(R.id.textanlam);

        bgeri.setOnClickListener(this);
        bileri.setOnClickListener(this);
        boku.setOnClickListener(this);

        tt=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR){
                    tt.setLanguage(Locale.ENGLISH);
                }

            }
        });


    }

    @Override
    protected void onPause() {
        SharedPreferences.Editor ed=p.edit();
        ed.putInt("a",i);
        ed.commit();
        super.onPause();
    }

    @Override
    protected void onResume() {
        SharedPreferences.Editor ed=p.edit();
        ed.putInt("a",i);
        ed.commit();
        super.onResume();
    }

//    private void showFullPage(){
//
//        bannerIndex++;
//
//        if (bannerIndex>=8){
//            bannerIndex=0;
//            mInterstitialAd.loaded(new AdRequest.Builder().build());
//
//            mInterstitialAd.setAdListener(new AdListener() {
//                @Override
//                public void onAdLoaded() {
//                    super.onAdLoaded();
//                    if (mInterstitialAd.isLoaded()){
//                        mInterstitialAd.show();
//                    }
//                }
//            });
//        }
//
//
//    }

//    private void reklamiYukle(){
//        MobileAds.initialize(this,
//        getResources().getString(R.string.apps_id));
//        MobileAds.initialize(
//                this,
//                new OnInitializationCompleteListener() {
//                    @Override
//                    public void onInitializationComplete(InitializationStatus initializationStatus) {}
//                });
//
//        adView = findViewById(R.id.reklam);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        adView.loadAd(adRequest);
//
//
//        mInterstitialAd = new InterstitialAd(this);
//        mInterstitialAd.setAdUnitId(getResources().getString(R.string.Page));
//
//
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btnileri : veriilerlet();
            //showFullPage();
                break;
            case R.id.btngeri : verigerilet();
            //showFullPage();
                break;
            case R.id.btnoku : anlamgetir();

                break;
        }

    }


    private void anlamgetir() {
        String tospeak=tvingkelime.getText().toString();
        tt.speak(tospeak,TextToSpeech.QUEUE_FLUSH,null);
        goster(i);



    }

    private void verigerilet() {
        if (!(i<=0)){
            i--;
            goster(i);

        }else if (i==0){
            i=ingveri.length-1;
            goster(i);
        }

    }

    private int goster(int i) {
        tvingkelime.setText(ingveri[i]);
        if (tt.isSpeaking()) {
            tvtürk.setText(anlamveri[i]);

        }else tvtürk.setText("   ");
        return i;
    }

    private void veriilerlet() {
        if(!(i>=(ingveri.length)-1)){
            i++;
            goster(i);


        } else if (i==(ingveri.length)-1) {
            i=0;
            goster(i);

        }
    }



}
