/** replaceFragment
     *  replaces fragment on placeholder with new fragment using Fade animation
     * @param fragment -> Fragment to be inflated (Ex: new MyFragment())
     * @param tag -> tag for fragment for backStack identification (Ex: "Myfragment")
     * @param context -> Activity holding the fragment
     * @param fragment_placeholder -> id of the fragment placeholder (Ex: R.id.fragment_placeholder)
     */
    public static void replaceFragment(Fragment fragment, String tag, AppCompatActivity context, int fragment_placeholder) { //R.id.fragment_placeholder
        android.support.v4.app.FragmentTransaction ft = context.getSupportFragmentManager().beginTransaction();
        ft.addToBackStack(tag);
        ft.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
        ft.replace(fragment_placeholder, fragment, tag).commit();
    }

    /** addFragment
     *  adds fragment on placeholder using Fade animation
     * @param fragment -> Fragment to be added (Ex: new MyFragment())
     * @param tag -> tag for fragment for backStack identification (Ex: "Myfragment")
     * @param context -> Activity holding the fragment
     * @param fragment_placeholder -> id of the fragment placeholder (Ex: R.id.fragment_placeholder)
     */
    public static void addFragment(Fragment fragment, String tag, AppCompatActivity context, int fragment_placeholder) { //R.id.fragment_placeholder
        android.support.v4.app.FragmentTransaction ft = context.getSupportFragmentManager().beginTransaction();
        ft.addToBackStack(tag);
        ft.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
        ft.add(fragment_placeholder, fragment, tag).commit();
    }

    /** removeFragment
     *  Removes fragment from given activity
     * @param fragment -> Fragment to be removed
     * @param context -> Activity holding the fragment
     */
    public static void removeFragment(Fragment fragment, AppCompatActivity context) {
        android.support.v4.app.FragmentTransaction ft = context.getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(android.R.animator.fade_out, android.R.animator.fade_in);
        ft.remove(fragment).commit();
    }

    /** callActivity
     *  Calls another Activity
     * @param rootActivity -> Activity calling the newActivity
     * @param newActivity -> Activity being called
     */
    public static void callActivity(Activity rootActivity, Activity newActivity) {
        rootActivity.startActivity(new Intent(rootActivity.getApplicationContext(), newActivity.getClass()));
    }

    /** callActivityByIntent
     *  Calls another Activity using Intent
     * @param rootActivity -> Activity calling the newActivity
     * @param newActivity -> Intent being called
     */
    public static void callActivityByIntent(Activity rootActivity, Intent newActivity) {
        rootActivity.startActivity(newActivity);
    }