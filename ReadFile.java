/**
	 * ReadFile() reads a file and returns each uncommented line with a length greater than 0.
	 * The class should have a private static boolean DEBUG set to either true or false.
	 *
	 * @param inFileName a string representing the file to open.
	 * @return an ArrayList<String> containing every non-empty line from the input file, or null if the file could not be opened.
	 */
	private static List< String > ReadFile( String inFileName )
	{
		String commentString = "//";
		// Attempt to open the file using "try with resources", to ensure it will close automatically.
		try( BufferedReader inBR = new BufferedReader( new FileReader( inFileName ) ) )
		{
			List< String > inAl = new ArrayList<>();
			String line;
			int inputLineCount = 0;

			// Read lines until EOF.
			while( ( line = inBR.readLine() ) != null )
			{
				inputLineCount++;
				// Check for comments.
				if( line.contains( commentString ) )
				{
					// Grab all of the text up to the comment.
					String subString = line.substring( 0, line.indexOf( commentString ) );

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
							System.out.println( "ReadFile is skipping a line that has only comments at row " + inputLineCount );
						}
					}
				}
				else
				{
					// Ignore empty lines and lines that contain only whitespace.
					if( line.length() > 0 && !line.matches( "\\s+" ) )
					{
						// Add the line to our ArrayList.
						inAl.add( line.trim() );
					}
					else
					{
						if( DEBUG )
						{
							System.out.println( "ReadFile is skipping a zero length line at row " + inputLineCount );
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
