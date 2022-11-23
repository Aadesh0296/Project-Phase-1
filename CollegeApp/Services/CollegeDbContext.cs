global using Microsoft.EntityFrameworkCore;

namespace CollegeApp.Services;

public class CollegeDbContext : DbContext
{
    public DbSet<Course> Courses { get; set; }

    public DbSet<Student> Students { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
    {
        optionsBuilder.UseSqlServer("Server=(localdb)\\METIIT;Database=MET");
    }

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<Course>()
            .ToTable("course")
            .Property(p => p.Id)
            .HasColumnName("courseId");
        modelBuilder.Entity<Student>()
            .ToTable("student")
            .Property(p => p.Id)
            .HasColumnName("studentId");
    }
}
