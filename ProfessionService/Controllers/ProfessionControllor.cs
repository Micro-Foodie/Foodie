using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using System.Collections.Generic;

using auth.Database;
using auth.Models;

[ApiController]
[Route("api/[controller]")]  // RESTful 风格

public class ProfessionController : ControllerBase
{
    private AppDbContext _database;

    public ProfessionController(AppDbContext appDbContext)
    {
        _database = appDbContext;  // 依赖注入，在整个类中使用它来进行数据库操作
    }

    [HttpPost("ApplyForProfession")] // 提交专业认证申请（用户）
    public async Task<IActionResult> ApplyForProfessionAsync(int user_id, string illustrate, string evidence)//提交专业认证申请（用户）
    {
        var code = 200;
        var msg = "";

        bool existUser = _database.Users.Any(x => x.UserId == user_id);  //  Any() 方法来检查是否存在任何匹配 UserId 的记录
        if (!existUser)
        {
            code = 400;
            msg = "用户不存在";
            return Ok(new
            {
                code = code,
                msg = msg,
            });
        }

        // 判断该用户是否已经是专业厨师：取 Profession 表查找是否存在 UserId = user_id 且 IsAccepted = 1 的记录
        // IsAccepted 等于 1 表示已经同意申请，用户已经是专业厨师
        // IsAccepted 等于 0 表示正在申请中
        // IsAccepted 等于 2 表示申请被拒绝
        bool existProfessionalChef = _database.Professions.Any(x => x.UserId == user_id && x.IsAccepted == 0);
        if (existProfessionalChef)
        {
            code = 401;
            msg = "请勿重复提交申请";
            return Ok(new
            {
                code = code,
                msg = msg,
            });
        }

        // 创建一个 Profesion() 对象
        var newProfession = new Profession()
        {
            UserId = user_id,
            ApplyTime = DateTime.Now,
            Illustrate = illustrate,
            Evidence = evidence,
            IsAccepted = 0
        };

        _database.Professions.AddRange(newProfession);
        await _database.SaveChangesAsync();
        code = 200;
        msg = "申请成功";
        return Ok(new
        {
            code = code,
            msg = msg
        });
    }
}