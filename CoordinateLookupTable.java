

//This interface contains coordinates for the GUI
//translated to chess squares
//However keep in mind that pawns, since shorter,
//require different y coordinates (those from the PP table) than main pieces
//X coordinates however will be used from the MP table

//Side note: Yes I'm fully aware that this is a horrible solution
// but it is 4 AM on Christmas, cut me some slack

//MP is for major pieces, PP is for pawn pieces
public interface CoordinateLookupTable {
	public static final double[] xyCoordinates_MP = {
			-13,63,137,212,287,362,437,512
		//   A  B   C   D   E   F   G   H
		//   8  7   6   5   4   3   2   1 
	};
	
	public static final double[] yCoordinates_PP = {
		    -18,57,132,207,282,357,432,507
		//   8  7   6   5   4   3   2   1 
	};
	
	
	public static final String A1="A1";
	public static final String A2="A2";
	public static final String A3="A3";
	public static final String A4="A4";
	public static final String A5="A5";
	public static final String A6="A6";
	public static final String A7="A7";
	public static final String A8="A8";
	public static final String B1="B1";
	public static final String B2="B2";
	public static final String B3="B3";
	public static final String B4="B4";
	public static final String B5="B5";
	public static final String B6="B6";
	public static final String B7="B7";
	public static final String B8="B8";
	public static final String C1="C1";
	public static final String C2="C2";
	public static final String C3="C3";
	public static final String C4="C4";
	public static final String C5="C5";
	public static final String C6="C6";
	public static final String C7="C7";
	public static final String C8="C8";
	public static final String D1="D1";
	public static final String D2="D2";
	public static final String D3="D3";
	public static final String D4="D4";
	public static final String D5="D5";
	public static final String D6="D6";
	public static final String D7="D7";
	public static final String D8="D8";
	public static final String E1="E1";
	public static final String E2="E2";
	public static final String E3="E3";
	public static final String E4="E4";
	public static final String E5="E5";
	public static final String E6="E6";
	public static final String E7="E7";
	public static final String E8="E8";
	public static final String F1="F1";
	public static final String F2="F2";
	public static final String F3="F3";
	public static final String F4="F4";
	public static final String F5="F5";
	public static final String F6="F6";
	public static final String F7="F7";
	public static final String F8="F8";
	public static final String G1="G1";
	public static final String G2="G2";
	public static final String G3="G3";
	public static final String G4="G4";
	public static final String G5="G5";
	public static final String G6="G6";
	public static final String G7="G7";
	public static final String G8="G8";
	public static final String H1="H1";
	public static final String H2="H2";
	public static final String H3="H3";
	public static final String H4="H4";
	public static final String H5="H5";
	public static final String H6="H6";
	public static final String H7="H7";
	public static final String H8="H8";
	
	public static final String[] squareNames = {
			  A1,A2,A3,A4,A5,A6,A7,A8,
			  B1,B2,B3,B4,B5,B6,B7,B8,
			  C1,C2,C3,C4,C5,C6,C7,C8,
			  D1,D2,D3,D4,D5,D6,D7,D8,
			  E1,E2,E3,E4,E5,E6,E7,E8,
			  F1,F2,F3,F4,F5,F6,F7,F8,
			  G1,G2,G3,G4,G5,G6,G7,G8,
			  H1,H2,H3,H4,H5,H6,H7,H8
		};
}
