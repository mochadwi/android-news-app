# android-news-app
News Mobile Apps (Kotlin + MVP + RxJava + Realm + Micro-apps)

### How to run
`
  $: git clone [this-url]
  $: git submodule foreach git pull #this repo using multi repo due to micro-apps [my articles](https://medium.com/@mochadwi/android-modularize-your-projects-d90733a03291)
  $: chmod +x ./gradlew
  $: ./gradlew --stacktrace clean assembleProdDebug #default flavour to prod
`

### What this repo contains

- The codebase was written in _**Kotlin**_ language by love

- _**Glide**_ (Image loading on articles)

- _**RxJava**_ (Implemented on SearchView)

- _**Retrofit + Okthttp**_ ([Unsafe SSL client included](https://medium.com/@mochadwi/android-okhttp-handshake-failed-32eae4163a6d), implement rest client endpoint and generator)

- _**Realm**_ (Store the actual API response to the local database, implement custom model Serializer to support Gson & Realm side by side: [original article](https://medium.com/@mochadwi/android-gson-realm-side-by-side-cd83e0230363))

- _**ButterKnife**_ (View binding omit the bloated findViewById)

- _**Koda Time**_ (Ease of use LocalDate than traditional java.util.Date)

- _**Gson**_ (Ease of use to convert JSON to POJO & vice versa)

- _**RelativeTimeTextView**_ (Show the actual time articles has been published: "Published Now, Published 2 Hours Ago, etc")

- _**ReadMore**_ (To trim long text view)

- Using Flavour dimension to switch between prod & dev environment (Separate actual codebase, and to allow multiple installation on the same phone, due to different package so it isn't conflicted each other)

- _**CardView**_ (Material Design-ish)

- _**ConstraintLayout**_ (Ease of use building xml layout)

- _**Gitlab CI**_ (CI / CD on Gitlab using .gitlab-ci.yml, for develop branch, previously this is my private project on gitlab)

- _**UI & Unit Test**_ not implemented (I'm still figuring it out why it is error with Realm when running the test: [Reference](https://medium.com/@mochadwi/android-unit-test-in-kotlin-6470ed80b989))


### What patterns I've used
- I'm using simple clean MVP pattern (Model-View-Presenter) inspired by [Google Architecture](https://github.com/googlesamples/android-architecture/tree/todo-mvp-clean/)

 
### Downloadable APK
- Source code (available on this repo)

- APK (attached [here](https://drive.google.com/open?id=1ZK3M_HK_edEF258TB8acW39Ffqqmhn7w) gdrive link to this email, zipped, signed version)
