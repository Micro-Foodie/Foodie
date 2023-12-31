using auth.Models;
using Microsoft.EntityFrameworkCore;

// 创建数据库上下文：
// 数据库上下文类是为给定数据模型协调 EF Core 功能的主类。 
// 上下文派生自 Microsoft.EntityFrameworkCore.DbContext。 
// 上下文指定数据模型中包含哪些实体。

namespace auth.Database;

public class AppDbContext : DbContext
{
    public AppDbContext(DbContextOptions<AppDbContext> options) : base(options) { }

    public DbSet<Article> Articles { get; set; }  // 对应 Models/Article.cs
    public DbSet<User> Users { get; set; }  // 对应 Models/User.cs
    public DbSet<Like> Likes { get; set; }  // 对应 Models/Like.cs
}
