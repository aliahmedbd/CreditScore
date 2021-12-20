# Credit Score Calculation

The repository has contains the tecnical task regarding Credit Score viewer, where an Android project is created and followed the steps which were mentioned in the document. I named the application is <b>Credit Score Calculation</b> 

Here is the screenshots of the application:

<img src="https://github.com/aliahmedbd/CreditScoreTechnicalTask/blob/main/Screenshot%202021-12-19%20at%205.45.34%20PM.png" alt="" data-canonical-src="https://github.com/aliahmedbd/CreditScoreTechnicalTask/blob/main/Screenshot%202021-12-19%20at%205.45.34%20PM.png" width="200" height="400" />  <img src="https://github.com/aliahmedbd/CreditScoreTechnicalTask/blob/main/Screenshot%202021-12-19%20at%205.45.12%20PM.png" alt="" data-canonical-src="https://github.com/aliahmedbd/CreditScoreTechnicalTask/blob/main/Screenshot%202021-12-19%20at%205.45.12%20PM.png" width="200" height="400" /> 

APK link: https://github.com/aliahmedbd/CreditScoreTechnicalTask/blob/main/app-debug.apk


## Application Flow

1. A splash screen will be appeared
2. After splash screen loaded successfully then Dashboard will be appeard. In Dashboard there will be a Donut view where you can see the Credit Score with the Credit score limit.
3. Other segment also introduced for other parameters visibility, where the data is fetching from the API.

## Technical Description

Here is the list of technologies are used to build this application:

1. <b>Kotlin</b>
2. <b>MVVM Architecture</b>: MVVM architecure is followed for the code boilerplate. Where View, ViewModel, Repisitory are clearly used for maintailed the SOLID principle.
3. <b>Motion Layout</b> : `MotionLayout` is used for animate the app icon in the Splash screen.
4. <b> Retrofit, OkHttp</b> : To fetch the data from API, I have used the network library which is Retrofit and for logging used OkHttp.
5. <b>Kotlin Coroutine</b> : To reduce the main thread task we can divide the task in many thread asychronously using the Kotlin Coroutine using `lifecycle` scope. Here is the sample example:   
```java
   lifecycleScope.launch {
          
        }
```
6.  <b>Hilt (Dependancy Injection used)</b> For dependancy injection I used HILT.
7.  <b>Unit Testing (JUnit, Google Truth)</b>: In this project I also introduced the in line Unit Testing code. For Unit testing I used JUnit and Google Truth. Google truth is used to see the clear visibility of any error. Here is the example of Unit Tesing code:

```java
      @Test
    fun `valid credit score`() {
        val result = CreditScoreUtil.validateCreditScore("...")
        assertThat(result).isFalse()
    }

    @Test
    fun `valid progress calculation`() {
        val result = CreditScoreUtil.calculateProgress(creditScore = 350, maxCreditScore = 700)
        assertThat(result).isEqualTo(50)
    }
```

Thanks for reading the technical documentation, if you wanted to know further please mail me at aliahmedaiub@gmail.com.




