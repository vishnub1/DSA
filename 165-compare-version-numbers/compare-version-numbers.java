class Solution {
    public int compareVersion(String version1, String version2) {
        String version1List[] = version1.split("\\.");
        String version2List[] = version2.split("\\.");

        int s1 = 0; // pointing version1
        int s2 = 0; // pointing version2

        while(s1 < version1List.length && s2 < version2List.length ) {
            int v1 = Integer.parseInt(version1List[s1]);
            int v2 = Integer.parseInt(version2List[s2]);
            s1++;
            s2++;
            
            if(v1 > v2) {
                return 1;
            } else if(v1 < v2) {
                return -1;
            } else {
                // Continue
            }
        }
        while(s1 < version1List.length) {
            int v1 = Integer.parseInt(version1List[s1]);
            s1++;
            if(v1 > 0) {
                return 1;
            }
        }
        while(s2 < version2List.length) {
            int v2 = Integer.parseInt(version2List[s2]);
            s2++;
            if(v2 > 0) {
                return -1;
            }
        }

        return 0; // equal
    }
}