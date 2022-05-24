import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTests {

    //TC_11_01 Подтвердите, что на странице по базовой ссылке в правом верхнем углу пользователь видит заголовок
    // 99 Bottles of Beer
    //
    //Шаги:
    //1. Открыть вебсайт на базовой странице
    //2. Считать заголовок в правом верхнем углу
    //3. Подтвердить, что текст заголовка соответствует ожидаемому
    //4. Закрыть браузер

    @Test
    public void testTitle(){

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\Users\\Alfa\\Downloads\\chromedriver_win32(1)\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "99 Bottles of Beer";


        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement title = driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='header']/h1"));

        String actualResult = title.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    //TC_11_02 Подтвердите, что на странице по базовой ссылке последний пункт меню называется Submit new Language
    //
    //Шаги:
    //1. Открыть вебсайт на базовой странице
    //2. Считать название последнего пункта меню
    //3. Подтвердить, что название последнего пункта меню соответствует ожидаемому
    //4. Закрыть браузер

    @Test
    public void testLastMenuTitle(){

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\Users\\Alfa\\Downloads\\chromedriver_win32(1)\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "Submit New Language";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement lastMenu = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/submitnewlanguage.html']")
        );

        lastMenu.click();

        WebElement titleLastMenu = driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='main']/h2"));

        String actualResult = titleLastMenu.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    //TC_11_03 Подтвердите, что на странице по базовой ссылке последний пункт меню имеет подзаголовок Submit new Language
    //
    //Шаги:
    //1. Открыть вебсайт на базовой странице
    //2. Нажать на пункт меню Submit new Language
    //3. Считать название подзаголовка последнего пункта меню
    //4. Подтвердить, что название подзаголовка последнего пункта меню соответствует ожидаемому
    //5. Закрыть браузер

    @Test
    public void testLastMenuSubtitle(){

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\Users\\Alfa\\Downloads\\chromedriver_win32(1)\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "Submit new Language";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement lastMenu = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/submitnewlanguage.html']")
        );

        lastMenu.click();

        WebElement lastMenuSubtitle = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='./submitnewlanguage.html']")
        );

        String actualResult = lastMenuSubtitle.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    //TC_11_04 Подтвердите, что на странице по ссылке http://www.99-bottles-of-beer.net/abc.html ,
    // первый пункт подменю называется 0-9
    //
    //Шаги:
    //1. Открыть вебсайт на странице
    //2. Считать название первого подзаголовка
    //3. Подтвердить, что название подменю соответствует ожидаемому
    //4. Закрыть браузер

    @Test
    public void testSubtitleStartMenu(){

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\Users\\Alfa\\Downloads\\chromedriver_win32(1)\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/abc.html";
        String expectedResult = "0-9 "; //negative test passed

        System.setProperty(chromeDriver, driverPath);

        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement browserLanguage = driver.findElement(By.xpath(
                "//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='0.html']"
        ));

        String actualResult = browserLanguage.getText();

        driver.quit();
    }

    //TC_11_06 Подтвердите, что имена создателей сайта:
    //Oliver Schade
    //Gregor Scheithauer
    //Stefan Scheler
    //
    //Шаги:
    //1. Открыть вебсайт на странице
    //2. Перейти в подменю Team
    //3. Считать названия создателей
    //4. Закрыть браузер

    @Test
    public void testAuthorsNames(){

        String chromedriver = "webdriver.chrome.driver";
        String driverPath = "C:\\Users\\Alfa\\Downloads\\chromedriver_win32(1)\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResultFirst = "Oliver Schade";
        String expectedResultSecond = "Gregor Scheithauer";
        String expectedResultThrid = "Stefan Scheler";

        System.setProperty(chromedriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement team = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='team.html']")
        );
        team.click();

        WebElement firstAuthor = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/h3[1]")
        );
        String actualResultFirst =  firstAuthor.getText();


        Assert.assertEquals(expectedResultFirst, actualResultFirst);

        WebElement secondAuthor = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/h3[2]")
        );
        String actualResultSecond =  secondAuthor.getText();
        Assert.assertEquals(actualResultSecond, expectedResultSecond);

        WebElement thridAuthor = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/h3[3]")
        );
        String actualResultThird =  thridAuthor.getText();
        Assert.assertEquals(actualResultThird, expectedResultThrid);

        driver.quit();
    }

    //TC_11_07 Придумайте и автоматизируйте свой собственный тест кейс на сайте http://www.99-bottles-of-beer.net/
    //На странице Top Rated 11 пункт, должен соответствовать языку Whitespace

    //1. Перейти на сайт http://www.99-bottles-of-beer.net/
    //2. Перейти во вкладку Top Lists
    //3. В подменю Top Rated найти пункт №11
    //4. Название языка должно быть Whitespace

    @Test
    public void testLanguageName(){

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\Users\\Alfa\\Downloads\\chromedriver_win32(1)\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "Whitespace";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement topList = driver.findElement(By.xpath(
                "//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/toplist.html']"
        ));
        topList.click();

        //can`t find element 11 menu

        WebElement findLanguage = driver.findElement(By.xpath(
                "//body/div[@id='wrap']/div[@id='main']/table[@id='category']/tbody/tr/td/a[@href='language-whitespace-154.html']"
        ));

        String actualResult = findLanguage.getText();
        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    //TC_11_11 Подтвердите, что если на странице по ссылке http://www.99-bottles-of-beer.net/submitnewlanguage.html ,
    // пользователь нажмет кнопку Submit Language,  не заполнив информацию в обязательных полях, будет показана ошибка
    //
    //Error: Precondition failed - Incomplete Input.
    //
    //Шаги:
    //1. Открыть вебсайт на странице
    //2. Нажать на кнопку Submit Language
    //3. Подтвердить, что на странице показана ошибка
    //4. Подтвердить, что текст ошибки соответствует ожидаемому
    //5. Закрыть браузер

    @Test
    public void testErrorSubmitNewLanguage(){

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\Users\\Alfa\\Downloads\\chromedriver_win32(1)\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement buttonSubmit = driver.findElement(By.xpath(
                "//body/div[@id='wrap']/div[@id='main']/form[@id='addlanguage']/p/input[@type='submit']"
        ));
        buttonSubmit.click();

        WebElement errorText1 = driver.findElement(By.xpath(
                "//body/div[@id='wrap']/div[@id='main']/p"
        ));
        String actualResult =  errorText1.getText();

        String expectedResult = "Error: Precondition failed - Incomplete Input.";

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }


    //TC_11_12 Precondition: Если на странице по ссылке http://www.99-bottles-of-beer.net/submitnewlanguage.html ,
    // пользователь нажмет кнопку Submit Language,  не заполнив информацию в обязательных полях,
    // будет показана ошибка с текстом
    //
    //Error: Precondition failed - Incomplete Input.
    //
    //Подтвертите, что в тексте ошибки слова Error, Precondition, Incomplete и Input написаны с большой буквы,
    // а слово failed  написано  с маленькой буквы.
    //Так же подтвердите, что в тексте ошибки содержатся знаки :, -  и .
    //
    //Шаги:
    //1. Открыть вебсайт на странице
    //2. Нажать на кнопку Submit Language
    //3. Считать текст ошибки
    //4. Подтвердить requirements
    //5. Закрыть браузер

    @Test
    public void testErrorText(){

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\Users\\Alfa\\Downloads\\chromedriver_win32(1)\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";
        String expectedResult = "Error: Precondition failed - Incomplete Input.";
        String expectedResult1 = "Error";
        String expectedResult2 = "Precondition";
        String expectedResult3 = "Incomplete";
        String expectedResult4 = "Input";
        String expectedResult5 = "failed";
        String expectedResult6 = ":";
        String expectedResult7 = "-";
        String expectedResult8 = ".";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement buttonSubmit = driver.findElement(By.xpath(
                "//body/div[@id='wrap']/div[@id='main']/form[@id='addlanguage']/p/input[@type='submit']"
        ));

        buttonSubmit.click();

        WebElement errorText = driver.findElement(By.xpath(
                "//body/div[@id='wrap']/div[@id='main']/p"
        ));

        Assert.assertEquals(errorText.getText().substring(0, 5), expectedResult1);
        Assert.assertEquals(errorText.getText().substring(7, 19), expectedResult2);
        Assert.assertEquals(errorText.getText().substring(29, 39), expectedResult3);
        Assert.assertEquals(errorText.getText().substring(40, 45), expectedResult4);
        Assert.assertEquals(errorText.getText().substring(20, 26), expectedResult5);
        Assert.assertEquals(errorText.getText().substring(5, 6), expectedResult6);
        Assert.assertEquals(errorText.getText().substring(27, 28), expectedResult7);
        Assert.assertEquals(errorText.getText().substring(45), expectedResult8);

        driver.quit();
    }

    //TC_11_13 Подтвердите, что на странице по ссылке http://www.99-bottles-of-beer.net/submitnewlanguage.html
    // в первом пункте списка пользователь видит текст
    //
    //IMPORTANT: Take your time! The more carefully you fill out this form
    // (especially the language name and description),
    // the easier it will be for us and the faster your language will show up on this page.
    // We don't have the time to mess around with fixing your descriptions etc. Thanks for your understanding.
    //
    //Шаги:
    //1. Открыть вебсайт на странице
    //2. Считать текст
    //3. Подтвердить, что текст соответствует ожидаемому
    //4. Закрыть браузер

    @Test
    public void testImportant(){

        String chromeDriver = "webdriver.chrome.driver";
        String driverPsth = "C:\\Users\\Alfa\\Downloads\\chromedriver_win32(1)\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";
        String expectedResult = "IMPORTANT: Take your time! The more carefully you fill out this form " +
                "(especially the language name and description), " +
                "the easier it will be for us and the faster your language will show up on this page. " +
                "We don't have the time to mess around with fixing your descriptions etc. Thanks for your understanding.";

        System.setProperty(chromeDriver, driverPsth);
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement textImportant = driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='main']/ul/li[1]"));
        String actualResult =  textImportant.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    //TC_11_14 Подтвердите, что нажав на пункт меню Browse Languages,
    // пользователь увидит таблицу со следующими названиями для первого и второго столбцов:
    //Language
    //Author
    //
    //Шаги:
    //1. Открыть вебсайт на базовой странице
    //2. Нажать на пункт меню Browse Languages
    //3. Считать названия первого и второго столбцов таблицы
    //3. Подтвердить, что названия соответствует ожидаемым
    //4. Закрыть браузер

    @Test
    public void testTableBrowseLanguage(){

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\Users\\Alfa\\Downloads\\chromedriver_win32(1)\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/abc.html";
        String expectedResultLanguage = "Language";
        String expectedResultAuthor = "Author";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuBrowsLanguages = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li[@class='sel']/a[@href='/abc.html']")
        );

        menuBrowsLanguages.click();

        WebElement tableNameLnguage = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/table[@id='category']/tbody/tr[1]/th[1]")
        );
       String actualResultLanguage = tableNameLnguage.getText();
       Assert.assertEquals(actualResultLanguage, expectedResultLanguage);

        WebElement tableNameAuthor = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/table[@id='category']/tbody/tr[1]/th[2]")
        );
        String actualResultAuthor = tableNameAuthor.getText();
        Assert.assertEquals(actualResultAuthor, expectedResultAuthor);

        driver.quit();
    }

    //TC_11_15 Подтвердите, что на странице по базовой ссылке  пользователь НЕ увидит новые комментарии,
    // если нажмет на пункты меню Top List → New Comments
    //
    //Шаги:
    //Придумать самостоятельно.

    @Test
    public void testComments(){
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\Users\\Alfa\\Downloads\\chromedriver_win32(1)\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuTopLists = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/toplist.html']")
        );

        menuTopLists.click();

        WebElement subMenuTopHits = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='./newcomments.html']")
        );
        subMenuTopHits.click();

        WebElement noComment = driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='main']/p"));
        String actualResult = noComment.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    //TC_11_21 Подтвердите, что на странице по ссылке http://www.99-bottles-of-beer.net/submitnewlanguage.html
    // пользователь видит предупреждение IMPORTANT:, написанное белыми буквами bold шрифтом на красном фоне,
    // и что все буквы - capital
    //
    //Шаги:
    //1. Открыть вебсайт на странице
    //2. Считать слово IMPORTANT: из списка
    //3. Подтвердить requirenments
    //4. Закрыть браузер

    @Test
    public void testBold(){
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\Users\\Alfa\\Downloads\\chromedriver_win32(1)\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";
        String expectedResult = "IMPORTANT:";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        String bold = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/ul/li/span/b")
        ).getTagName();
        Assert.assertEquals(bold, "b");

        WebElement important = driver.findElement
                (By.xpath("//body/div[@id='wrap']/div[@id='main']/ul/li/span[@style='background-color:red; color: white']"));
        String actualResult = important.getText();

        Assert.assertEquals(actualResult, expectedResult.toUpperCase());

        String backgroundColor = important.getCssValue("background-color");
        Assert.assertTrue(Color.fromString("#ff0000").equals(Color.fromString(backgroundColor)));

        String color = important.getCssValue("color");
        Assert.assertTrue(Color.fromString("#ffffff").equals(Color.fromString(color)));

        driver.quit();


            }


























}
