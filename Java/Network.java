
 /** isConnectedToWifi
     *  Returns either device is connected to Wifi or not
     * @param context -> Context for conectivity service (Ex: activity.getApplicationContext())
     * @return Boolean true -> is conected / false -> is not connected
     */
    public static boolean isConnectedToWifi(Context context){
        ConnectivityManager connManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        return mWifi.isConnected();
    }
	
	
	