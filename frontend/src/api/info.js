// 本文件存放与用户/管理员相关的接口请求函数

import Request from "@/utils/Request/info.js";  // 在每个 api 文件里都要引入这两个文件
import Message from "@/utils/Message.js"  // 在每个 api 文件里都要引入这两个文件
import router from "@/router/index.js"

//通过Email获取用户/管理员信息
export function InfoByEmail(params) {
    return Request({
        method: 'GET',
        url: 'info/InfoByEmail',
        params: params
    }).then(function (response) {
        if (response.data.code === 200) {
            return response.data;  // 正确响应，返回数据
        } else {
            Message.error("信息获取失败");
        }
    }).catch(function (error) {
        console.log(error);
    });
}

//通过ID获取用户/管理员信息
export function InfoByID(params) {
    return Request({
        method: 'GET',
        url: 'info/InfoByID',
        params: params
    }).then(function (response) {
        if (response.data.code === 200) {
            return response.data;  // 正确响应，返回数据
        } else {
            Message.error("信息获取失败");
        }
    }).catch(function (error) {
        console.log(error);
    });
}

// 更改用户积分
export function changePoint(params) {
    return Request({
        method: 'POST',
        url: 'info/changePoint',
        params: params
    }).then(function (response) {
        if (response.data.code === 200) {
            Message.success("success");
            return response.data;
        } else {
            Message.error("error");
        }
    }).catch(function (error) {
        console.log(error);
    });

    
}

// 更改用户信息
export function editInfo(params) {
    return Request({
        method: 'POST',
        url: 'info/edit',
        params: params
    }).then(function (response) {
        if (response.data.code === 200) {
            Message.success("success");
            return response.data;
        } else {
            Message.error("error");
        }
    }).catch(function (error) {
        console.log(error);
    });
}

// 显示图片/用户头像不需要api，直接通过url就行
const config = {
    headers: {
        'Content-Type': 'multipart/form-data'
    }
};

// 上传用户头像
// 将参数放到 formData 表单里面
// database-front-web/src/components/avatarUploader.vue
export function uploadAvatar(formData) {
    return Request({
        method: "POST",
        url: 'info/uploadAvatar',
        data: formData,
        headers: config.headers
    }).then(function (response) {
        if (response.data.code === 200) {
            Message.success("上传成功");
        } else {
            Message.error("请求成功，但上传失败");
        }
    }).catch(function (error) {  // catch 表示接收到错误响应后的操作        
        Message.error("请求失败，且上传失败");
    });
}