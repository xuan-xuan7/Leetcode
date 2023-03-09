#define MIN(a, b) ((a) < (b) ? (a) : (b))

int minimumRecolors(char * blocks, int k){
    int ans = 0;
    int len = strlen(blocks);
    int l = 0;
    int r = 0;
    int cnt = 0;
    while(r < k){
        cnt += blocks[r] == 'W' ? 1 : 0;
        r ++;
    }
    ans = cnt;
    while(r < len){
        cnt += blocks[r] == 'W' ? 1 : 0;
        cnt -= blocks[l] == 'W' ? 1 : 0;
        ans = MIN(ans, cnt);
        r ++;
        l ++;
    }
    return ans;
}