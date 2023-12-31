import Request from "@/utils/Request/article.js";  // 在每个 api 文件里都要引入这两个文件
import Message from "@/utils/Message.js"  // 在每个 api 文件里都要引入这两个文件
import router from "@/router/index.js"

// 加载文章
export function loadArticle(params) {
    return Request({
        method: 'GET',
        url: 'Article/loadArticle',
        params: params
    }).then(function (response) {
        if (response.data.code === 200) {
            return response.data;  // 返回 code + msg + data
        } else {
            Message.error("文章加载失败");
            return null;
        }
    }).catch(function (error) {
        console.log(error);
    })
}

export function recommendArticle(params) {
    return Request({
        method: 'GET',
        url: 'Article/recommendArticle',
        params: params
    }).then(function (response) {
        if (response.data.code === 200) {
            return response.data;  // 返回 code + msg + data
        } else {
            Message.error("推荐文章加载失败");
            return null;
        }
    }).catch(function (error) {
        console.log(error);
    })
}

// 获取用户的文章列表
export function searchArticle(params) {
    return Request({
        method: 'GET',
        url: 'Article/search',
        params: params
    }).then(function (response) {
        if (response.data.code === 200) {
            return response.data;
        } else if (response.data.code === 404) {
            Message.error("没有发布的文章");
            return null;
        } else if (response.data.code === 400) {
            Message.error("参数无效");
            return null;
        }
    }).catch(function (error) {
        console.log(error);
    });
}

// navTop 根据关键词去搜索文章列表
export function searchArticles(params) {
    return Request({
        method: 'GET',
        url: 'Article/searchArticle',
        params: params
    }).then(function (response) {
        if (response.data.code === 200) {
            return response.data;
        }
    }).catch(function (error) {
        console.log(error);
    });
}


//删除文章
export function removeArticle(params) {
    return Request({
        method: 'POST',
        url: 'Article/removeArticle',
        params: params
    }).then(function (response) {
        if (response.data.code === 200) {
            return response.data;
        } else if (response.data.code === 400) {
            Message.error("参数错误");
            return null;
        }
    }).catch(function (error) {
        console.log(error);
    })
}


// 获取文章详情
// modify by Xiang Lei 2023.8.16
export function GetArticleDetailsAsync(params) {
    return Request({
        method: 'GET',
        url: 'Article/viewArticle',
        params: params
    }).then(function (response) {
        if (response.data.code === 200) {
            return response.data;
        } else if (response.data.code === 404) {
            Message.error("帖子已被封禁");
            return null;
        }
    }).catch(function (error) {
        console.log(error);
        return null;
    });
}

// 获取用户的文章数量
export function getArticleNumber(params) {
    return Request({
        method: 'GET',
        url: 'Article/ArticleNumber',
        params: params
    }).then(function (response) {
        if (response.data.code === 200) {
            return response.data.data;
        } else if (response.data.code === 400) {
            Message.error("该用户未发布文章");
            return response.data.data;
        }
    }).catch(function (error) {
        console.log(error);
    });
}

//修改文章（传参：文章id+修改的标题+内容）
export function editArticle(params) {
    return Request({
        method: 'POST',
        url: 'Article/updateArticle',
        params: params
    }).then(function (response) {
        if (response.data.code === 200) {
            return response.data;
        } else if (response.data.code === 400) {
            Message.error("参数错误");
            return null;
        }
    }).catch(function (error) {
        console.log(error);
    });
}

// 浏览文章
export function viewArticle(params) {
    return Request({
        method: 'POST',
        url: 'Article/Articleview',
        params: params
    }).then(function (response) {
        if (response.data.code === 200) {
            return response.data;
        } else if (response.data.code === 400) {
            Message.error("参数错误");
            return null;
        }
    }).catch(function (error) {
        console.log(error);
    });
}

//发布文章
export function publishArticle(params) {
    const requestBody = {
        user_id: params.user_id,
        title: params.title,
        tag: params.tag,
        content: params.content,
        picture: params.picture,
        Sharelink: params.Sharelink,
    };

    return Request({
        method: 'POST',
        url: 'Article/publishArticle',
        data: requestBody, // 使用 data 属性传递请求正文体
    }).then(function (response) {
        if (response.data.code === 200) {
            Message.success("发布成功");
            return response.data;
        } else if (response.data.code === 400) {
            Message.error("发布失败");
        }
    }).catch(function (error) {
        console.log(error);
    });
}

export function topArticle(params) {
    return Request({
        method: 'Post',
        url: 'Article/topArticle',
        params: params
    }).then(function (response) {
        if (response.data.code === 200) {
            return response.data;  
        } else {
            Message.error("文章置顶失败");
            return null;
        }
    }).catch(function (error) {
        console.log(error);
    })
}

// 给文章点赞/取消点赞
export function like(params) {
    return Request({
        method: 'POST',
        url: 'Like/Like',
        params: params
    }).then(function (response) {
        if (response.data.code === 200) {
            Message.success(response.data.msg);  // 点赞/取消点赞成功
        } else if (response.data.code === 400) {
            Message.error("点赞失败");
        }
    }).catch(function (error) {
        console.log(error);
    });
}