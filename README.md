# VCF Hackathon
# MediCare

#### A medical app that allows you to book a doctor's appointment and order medicine online.
#### CONTRIBUTORS
<ul>
<li>Wendy Busolo</li> 
<li>Rachel Namiba</li>
<li>Gamaliel Sirengo</li>
<li>Lynn Nyangon</li>
<li>Cynthia Munyasya</li>
</ul>


## Description
This we app is developed using Java language, the app functionality is supported with Spark, InteliJ, SQL and heroku. The app allows patients to find doctors for consultation or find a drug they want thus saving them a lot of time.

## Prerequisites
- Basic Java, Android Studio and Git knowledge, including an installed version of Git.
- Your application must run on the OpenJDK version 11 onwards.

## Setup & Installation
* Clone the project into your machine
* Run the project in the forked root folder- gradle run.


## Behavior Driven Development
| Behavior :                                | Input:                                                                     | Output:
 | :---------------------------------------- | :--------------------------------------------------------------------------| :-------------         
|  Users Authentication                     | Patients login in or create users accounts                                  | Access received or denied
| Users gets access to a list of doctors    | User Books for an appointment                                              | List of appointments and visits updated.
| Users gets access to drug search field    | User searches for a drug                                                   | User is notified on the drug price plus the delivery amount.
| Users Rating                              | Users give their ratings on our services                                   | Feedback is taken and the user is notified.

## Technologies used
* Java- `Backend and frontend.`
* Gradle- `(For Project building).`
* Postman `For testing the end points.`
* Spring- `Backend.`
* PostgreSql- `For persistence data storage and retrieval`
* Junit- `Testing`

### Dependencies and Testing

<details>
  <summary> Check the dependencies here.</summary>

```
dependencies {

    implementation 'androidx.appcompat:appcompat:1.4.2'
    implementation 'com.google.android.material:material:1.6.1'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    implementation 'com.google.firebase:firebase-analytics:21.0.0'
    implementation 'com.google.firebase:firebase-auth:21.0.6'
    implementation 'com.google.firebase:firebase-database:20.0.5'
    implementation 'com.google.firebase:firebase-firestore:24.2.0'
    testImplementation 'junit:junit:4.13.2'
    //junit
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    //espresso
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
    //material design
    implementation 'com.google.android.material:material:1.6.1'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    implementation 'com.google.android.material:material:1.6.1'
    //Firebase  google analytics
    //Firebase realtime database
    //Firebase authentication
    //ButterKnife
    testImplementation 'junit:junit:4.13.2'
    implementation 'com.jakewharton:butterknife:10.2.0'
    annotationProcessor 'com.jakewharton:butterknife-compiler:10.2.0'
    //card view
    implementation "androidx.cardview:cardview:1.0.0"
    //Retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.5.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.5.0'
    //Glide
    implementation 'com.github.bumptech.glide:glide:4.13.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.13.0'
    //google truth
    implementation "com.google.truth:truth:1.1.3"
    androidTestImplementation "com.google.truth:truth:1.1.3"
    testImplementation "com.google.truth.extensions:truth-java8-extension:1.1.3"
    implementation "com.google.guava:guava:31.1-android"
    //daimaija animation
    implementation 'com.daimajia.androidanimations:library:2.4@aar'
    implementation "com.airbnb.android:lottie:3.4.0"
    //Rounded Image
    implementation 'com.makeramen:roundedimageview:2.3.0'
    //Navigation Component
    implementation 'androidx.navigation:navigation-fragment-ktx:2.5.0'
    implementation 'androidx.navigation:navigation-ui-ktx:2.5.0'
    //picasso
    implementation 'com.squareup.picasso:picasso:2.8'

//Robolectric dependencies
    testImplementation 'org.robolectric:robolectric:4.4'

}
```
</details>

## Development

Want to contribute? Great!
To fix a bug or enhance an existing module, follow these steps:

- Fork the repo
- Create a new branch (`git checkout -b improve-feature`)
- Make the appropriate changes in the files
- Add changes to reflect the changes made
- Commit your changes (`git commit -am 'Improve feature'`)
- Push to the branch (`git push origin improve-feature`)
- Create a Pull Request

## Known Bugs

If you find any other bug, kindly let us know here []()


## Support and contact details
contact   medicare@gmail.com.
