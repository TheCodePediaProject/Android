
/**
*
* ATTENTION, FOR THE METHOD sendBackgroundEmail a library is needed!
*		Add maven { url 'https://jitpack.io' } to your allprojects{repositories{  to your Build.gradle(Project) file
*	allprojects {
*   	repositories {
*       	maven { url "https://jitpack.io" }
*   	}
*	}
*
*
*		Add "implementation 'com.github.luongvo:GmailBackground:2.1.1'" to your build.gradle(Module) file
*		
*
*		Credits and further references: https://jitpack.io/p/luongvo/GmailBackground 
*/


/** sendBackgroundEmail
     * sends an email without any user input
     * @param context -> context of the application
     * @param senderEmail -> address of the sender e-mail
     * @param senderPassword -> password to the sender e-mail
     * @param subject -> subject of the email
     * @param body -> body of the e-mail
     * @param toWhom -> address to the receiver of the e-mail
     */
    public static void sendBackgroundEmail(Context context, String senderEmail, String senderPassword, String subject, String body, String toWhom) {
        BackgroundMail.newBuilder(context)
                .withUsername(senderEmail)
                .withPassword(senderPassword)
                .withMailTo(toWhom).withType(BackgroundMail.TYPE_PLAIN)
                .withSubject(subject)
                .withBody(body)
                .withUseDefaultSession(false)
                .withOnSuccessCallback(new BackgroundMail.OnSendingCallback() {
                    @Override
                    public void onSuccess() {
						// Do some magic.
                    }

                    @Override
                    public void onFail(Exception e) {
						// Do some magic.
                    }
                })
                .send();
    }