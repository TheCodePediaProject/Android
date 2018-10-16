


/** checkExternalMediaAvailability
     *  Returns either external storage is available for writing
     * @return Boolean true -> External storage is available / false -> External storage is not available
     */
    public static Boolean checkExternalMediaAvailability() {
        return (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()));
    }
	
	
	
	/** createFileToRoot
     *      Creates and returns a file with the name of the 'fileName' parameter.
     *      Full path will be "/Storage/Emulated/0/"filename"
     * @param fileName -> Name of the file to be created (Ex: "file.txt")
     * @return File on the device's root directory (/Storage/Emulated/0/)
     */
    public static File createFileToRoot(String fileName){ 
        String rootDirectory = android.os.Environment.getExternalStorageDirectory().getAbsolutePath();
        return new File(rootDirectory, getDiaAtual() + fileName);
    }
	
	
	
	/** createDirectoryIfNeeded
     *  Creates a directory for File if it doesn't yet exists 
     * @param directory -> File to be checked (Ex: /Storage/Emulated/0/Download)
     */
    public static void createDirectoryIfNeeded(File directory) {
        if (!directory.exists())
            directory.mkdir();
    }
	
	
	
	/** createFileOnPath
     *  Creates and returns file on given path
     * @param path     -> Path to the directory where the file is to be created (Ex: "/Storage/Emulated/0/Download")
     * @param fileName -> Name of the file to be created (Ex: "file.txt")
     * @return File on the given path
     */
    public static File createFileOnPath(String path, String fileName) {
        File directory = new File(path);
        createDirectoryIfNeeded(directory);
        return new File(directory, fileName);
    }
	
	/** writeToFile
     *  Writes text to given file
     * @param file   -> File to be written on
     * @param text   -> Text to be written on given file (Ex: "the codepedia project is awesome")
     * @param append -> Informs the method if it should clean the file before writing or not
     *                  if append is true -> write to file and leave any text that was already written
     *                  if append is false -> write to file and deletes everything prior to the method calling   
     */
    public static void writeToFile(File file, String text, Boolean append){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file, append);
            PrintWriter pw = new PrintWriter(fileOutputStream);
            pw.println(text);
            pw.flush();
            pw.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	
	
	/** deleteFile 
     *  Deletes a given file and returns a boolean (true if successfully deleted / false if not)
     * @param file -> File to be deleted
     * @return Boolean indicating if file was deleted successfully or not
     */
    public static Boolean deleteFile(File file) {
        return file.delete();
    }
	
	
	
	    /** readTextFromFile
     *  Reads text on file and returns it as a String
     * @param file -> File to be read from
     * @return String with the whole text of the file
     */
    public static String readTextFromFile(File file) {
        StringBuilder textOnFile = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                textOnFile.append(line);
				textOnFile.append("\n");
            }
            br.close();
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
        return textOnFile.toString();
    }