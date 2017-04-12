/**
 * ReadFile()
 *
 * @param inFileName a string representing the file to open.
 * @return an ArrayList<String> containing every line from the input file that contained characters.
 */
private static List<String> ReadFile( String inFileName )
{
	String line;        // A temporary String to hold the line we read in.
	List<String> inAl = new ArrayList<>();

	try
	{
		BufferedReader inBR = new BufferedReader( new FileReader( inFileName ) );
		// Read every line in the input file.
		while( ( line = inBR.readLine() ) != null )
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
					inAl.add( subString );
				}
				else
				{
					if( DEBUG )
					{
						System.out.println( "Skipping zero length line." );
					}
				}
			}
			else
			{
				// Add the line to our ArrayList.
				inAl.add( line );
			}
		}
	}
	catch( IOException ioe )
	{
		ioe.getMessage();
	}
	return inAl;
} // End of ReadFile() method.
