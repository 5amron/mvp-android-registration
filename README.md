# mvp-android-registration

This is an example of android MVP (model, view, presenter).

Nowdays MVP architecture is one of the most popular models that widely is being used by developers, i took advantages of this
model to make a simple login and registration app that is highly expandable, it's not perfectly finished, for example it 
doesn't show any progress indicator on view but it can add simply since its function still is called by presenter but it just doesn't do anything, thus, the blueprint is designed.

but the main important feature of my design is implementing (start) function in presenter that is desgin to switch between main fragment states. so basically we save state of the fragment in some cases like orientation-change that view is attached repeatedly.

we have three states :
- PROGRESS : in this case program is showing (but it isn't!) progress bar and is checking user login or sign up credentials.
- LOGIN : in this case program is showing loign inputs and buttons.
- SIGN UP : in this case program is showing registration inputs and buttons.

so simple!







![alt text](https://github.com/5amron/mvp-android-registration/blob/master/SamLoginSignupMvp/photo_2017-05-16_06-08-37.jpg)



