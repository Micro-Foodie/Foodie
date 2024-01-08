using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

using auth.Models;
using auth.Database;


[ApiController]
[Route("api/[controller]")]  // RESTful 风格
public class InfoController : ControllerBase  // 命名规范，继承自 ControllerBase 类的类名必须与 Controller 结尾
{

    private readonly AppDbContext _database;

    public InfoController(AppDbContext appDbContext)
    {
        _database = appDbContext;  // 依赖注入，在整个类中使用它来进行数据库操作。
    }

    //通过Email获取用户/管理员资料信息
    [HttpGet("InfoByEmail")]
    public IActionResult InfoByEmail(string email) // email 可以用来判断是管理员还是用户
    {
        // 在用户表中找到匹配的邮箱
        var user = _database.Users.Where(x => x.Email == email).ToList();
        if (user.Any())
        {
            var firstUser = user.First();
            return Ok(new
            {
                code = 200,
                msg = "success",
                data = new
                {
                    id = firstUser.UserId,
                    email = firstUser.Email,
                    password = firstUser.PassWord,
                    avatar = firstUser.Avatar,
                    tel = firstUser.Tel,
                    name = firstUser.UserName,
                    levels = firstUser.Levels,
                    points = firstUser.Points
                }
            });
        }

        // 在管理员表中找到匹配的邮箱
        var admin = _database.Administrators.Where(x => x.Email == email).ToList();
        if (admin.Any())
        {
            var firstAdmin = admin.First();
            return Ok(new
            {
                code = 200,
                msg = "success",
                data = new
                {
                    id = firstAdmin.AdminId,
                    email = firstAdmin.Email,
                    password = firstAdmin.PassWord,
                    avatar = firstAdmin.Avatar,
                    tel = firstAdmin.Tel,
                    name = firstAdmin.AdminName
                }
            });
        }

        // 如果在用户表和管理员表都找不到，返回错误信息
        return Ok(new
        {
            code = 404,
            msg = "在用户表和管理员表都找不到",
        });
    }

    // 通过ID获取用户/管理员资料信息
    [HttpGet("InfoByID")]
    public IActionResult InfoByID(int ID, int type) // 参数type:0为管理员，1为普通用户
    {
        if (type == 0)
        {
            var admin = _database.Administrators.Where(x => x.AdminId == ID).ToList();
            if (admin.Any())
            {
                var firstAdmin = admin.First();
                return Ok(new
                {
                    code = 200,
                    msg = "已返回管理员信息",
                    data = new
                    {
                        id = firstAdmin.AdminId,
                        email = firstAdmin.Email,
                        password = firstAdmin.PassWord,
                        avatar = firstAdmin.Avatar,
                        tel = firstAdmin.Tel,
                        name = firstAdmin.AdminName
                    }
                });
            }
        }
        else if (type == 1)
        {
            var user = _database.Users.Where(x => x.UserId == ID).ToList();
            if (user.Any())
            {
                var firstUser = user.First();
                return Ok(new
                {
                    code = 200,
                    msg = "已返回用户信息",
                    data = new
                    {
                        id = firstUser.UserId,
                        email = firstUser.Email,
                        password = firstUser.PassWord,
                        avatar = firstUser.Avatar,
                        tel = firstUser.Tel,
                        name = firstUser.UserName,
                        levels = firstUser.Levels,
                        points = firstUser.Points
                    }
                });
            }
        }
        else
        {
            return Ok(new
            {
                code = 400,
                msg = "type值无效"
            });
        }

        return Ok(new
        {
            code = 400,
            msg = "不存在该用户或管理员",
        });
    }

    //更改用户积分
    [HttpPost("changePoint")]
    public async Task<IActionResult> UserchangePoint(int user_id,int point_add,int level_add) // 传入增加的参数
    {
        
        // 在用户表中找到匹配的用户
        var user = _database.Users.Where(x => x.UserId == user_id);
        if (user.Any())
        {
            foreach (var item in user)
            {
                item.Points = item.Points+point_add;
                item.Levels = item.Levels+level_add;
            }
            await _database.SaveChangesAsync();
            return Ok(new
            {
                code = 200,
                msg = "success",
            });
        }
        else{
            // 如果在用户表找不到，返回错误信息
            return Ok(new
            {
                code = 400,
                msg = "Not Found",
            });
        }
        
    }

     //编辑个人信息
     //返回用户认证令牌(Token)未实现
     [HttpPost("edit")]
     public async Task<IActionResult> EditAsync(int Id, string name, string password)
     {
         var code = 200;
         var msg = "success";
         var user_data = _database.Users.Where(x => x.UserId == Id);
         bool exist = false;

        foreach (var item in user_data)
             {
                 if (item.UserId == Id)
                 {
                     exist = true;
                     break;
                 }
             }
         if(exist){
             //参数无效，返回401
             if (name == null || password == null )
            {
                code = 401;
                msg = "参数无效";
                return Ok(new
               {
                 code = code,
                 msg = msg,
               });
            }
            else{
                foreach (var item in user_data)
             {
                 item.UserName = name;
                 item.PassWord = password;
             }
             await _database.SaveChangesAsync();
             return Ok(new
               {
                 code = code,
                 msg = msg,
               });
            }
         }
         else{
             code = 400;
             msg = "不存在该用户信息";
             return Ok(new
             {
                 code = code,
                 msg = msg
             });
         }
    }

    // 返回用户头像
    [HttpGet("Avatar")]
    public IActionResult Avatar(int userId)
    {
        var user = _database.Users.FirstOrDefault(x => x.UserId == userId);
        if (user == null)
        {
            return Ok(new
            {
                code = 404,
                msg = "用户不存在",
            });
        }

        string? avatarPath = user.Avatar;

        string DefaultAvatarPath = Path.Combine("wwwroot", "images", "avatars", "default.jpg");

        if (!string.IsNullOrEmpty(avatarPath))
        {
            if (avatarPath.Equals(DefaultAvatarPath))
            {
                avatarPath = Path.Combine("wwwroot", DefaultAvatarPath);
            }
            else
            {
                avatarPath = Path.Combine("wwwroot", avatarPath);
            }

            if (System.IO.File.Exists(avatarPath))
            {
                var imageBytes = System.IO.File.ReadAllBytes(avatarPath);
                return File(imageBytes, "image/jpeg");
            }
        }

        return Ok(new
        {
            code = 404,
            msg = "用户头像不存在",
        });
    }

    // 前端通过 formdata 上传图片数据
    // 参考：https://www.cnblogs.com/leoxuan/articles/11087121.html
    // 必须要显示指明参数来自 [FromForm] 
    // 去掉 [FromForm] 后，可以在 swagger 上上传图片
    [HttpPost("uploadAvatar")]
    public IActionResult UploadAvatar([FromForm] int userId, [FromForm] IFormFile avatarFile)
    {
        var user = _database.Users.FirstOrDefault(x => x.UserId == userId);
        if (user == null)
        {
            return Ok(new
            {
                code = 404,
                msg = "用户不存在",
            });
        }
        user.Avatar = "images/avatars/" + userId.ToString() + ".jpg";
        _database.SaveChanges();
        string path = "wwwroot/images/avatars/" + userId.ToString() + ".jpg";  // 指定图片存储路径

        // 存储图片
        using (var stream = new FileStream(path, FileMode.Create))
        {
            avatarFile.CopyTo(stream);  // 将图片上传到指定路径
        }

        return Ok(new
        {
            code = 200,
            msg = "用户头像上传成功",
        });
    }
}