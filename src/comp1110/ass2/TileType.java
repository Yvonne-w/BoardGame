package comp1110.ass2;

public enum TileType {
    AACB,CBAA,ACBA,BAAC,AAAA,CBCB,BCBC,CCCC,BBBB,DACC,CDAC,CCDA,ACCD,DBBA,ADBB,BADB,BBAD,DDBC,CDDB,BCDD,DBCD,ADAD,DADA,DDDD, TileType;
    /*
    There are 60 tiles in total, with 2-4 copies of each tile as follows:
    4 copies of tiles aacb, cbaa, acba, baac, and aaaa;
    3 copies of tiles cbcb and bcbc; and,
    2 copies of all remaining tiles: cccc, bbbb, dacc, cdac, ccda, accd, dbba, adbb, badb, bbad, ddbc, cddb, bcdd, dbcd, adad, dada and dddd.
     */

    public static TileType fromString(String tilePlacement) {
        return TileType;
    }

}
