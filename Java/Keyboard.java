/** hideSoftInputKeyboard
     *  Hides the virtual keyboard on screen
     * @param activity -> activity holding the keyboard view
     */
    public static void hideSoftInputKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null && imm.isAcceptingText()) {
            imm.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }
    }