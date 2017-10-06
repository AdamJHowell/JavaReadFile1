/**
 * ReadFile() reads a file and returns each uncommented line with a length greater than 0.
 * The class should have a private static boolean DEBUG set to either true or false.
 *
 * @param inFileName a string representing the file to open.
 * @return an ArrayList<String> containing every non-empty line from the input file, or null if the file could not be opened.
 */
private static List< String > ReadFile( String inFileName )
{
	// Attempt to open the file using "try with resources", to ensure it will close automatically.
	try( BufferedReader inBR = new BufferedReader( new FileReader( inFileName ) ) )
	{
		List< String > inAl = new ArrayList<>();
		String line;

		// Read lines until EOF.
		while( ( line = inBR.readLine() ) != null )
		{
			// Check for comments.
			if( line.contains( "//" ) )
			{
				// Grab all of the text up to the comment.
				String subString = line.substring( 0, line.indexOf( "//" ) );

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
				if( line.length() > 0 )
				{
					// Add the line to our ArrayList.
					inAl.add( line );
				}
				else
				{
					if( DEBUG )
					{
						System.out.println( "Skipping zero length line." );
					}
				}
			}
		}
		return inAl;
	}
	catch( IOException ioe )
	{
		ioe.getMessage();
	}
	return null;
} // End of ReadFile() method.
