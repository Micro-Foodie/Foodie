// 本文件存放与举报留言信息相关的接口请求函数

import Request from "@/utils/Request/comment.js";  // 在每个 api 文件里都要引入这两个文件
import Message from "@/utils/Message.js"  // 在每个 api 文件里都要引入这两个文件
import router from "@/router/index.js"


//举报信息存入（评论-用户）
export function ReportComment(params){
    return Request({
        method: 'POST',
        url: 'ReportComment/CommentReport',
        params: params,
    }).then(function (response) {
        if (response.data.code === 200) {
            Message.success("举报成功");
            return response.data;  // 正确响应，返回数据
        } else {
            Message.error("举报失败");
        }
    }).catch(function (error) {
        console.log(error);
    });
}
