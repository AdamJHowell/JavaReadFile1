/**
	 * ReadFile()
	 * This method will read the contents of a text file, and return an ArrayList of Strings, where each element in the List is one line from the input file.
	 * I recently added the ability to handle comments marked with '//'.
	 *
	 * @param inFileName a string representing the file to open.
	 * @return an ArrayList<String> containing every line from the input file that contained characters.
	 */
	private static List<String> ReadFile( String inFileName )
	{
		String line;        // A temporary String to hold the line we read in.
		List<String> returnList = new ArrayList<>();

		try
		{
			BufferedReader inputBufferedReader = new BufferedReader( new FileReader( inFileName ) );
			// Read every line in the input file.
			while( ( line = inputBufferedReader.readLine() ) != null )
			{
				// Check for comments.
				if( line.contains( "//" ) )
				{
					int commentOffset = line.indexOf( "//" );
					String subString = line.substring( 0, commentOffset );

					// Only add lines with content.
					if( subString.length() > 0 )
					{
						// Add the line to our ArrayList.
						returnList.add( subString );
					}
					else
					{
						if( DEBUG )
						{
							System.out.println( "ReadFile() is skipping a zero length line." );
						}
					}
				}
				else
				{
					// Add the line to our ArrayList.
					returnList.add( line );
				}
			}
		}
		catch( IOException ioe )
		{
			ioe.getMessage();
		}
		return returnList;
	} // End of ReadFile() method.
