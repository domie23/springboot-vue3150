const base = {
    get() {
        return {
            url : "http://localhost:8080/bingfangguanlixitong/",
            name: "bingfangguanlixitong",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/bingfangguanlixitong/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "病房管理系统"
        } 
    }
}
export default base
