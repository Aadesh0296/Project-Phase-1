using CollegeApp.Services;

var builder = WebApplication.CreateBuilder(args);
builder.Services.AddControllersWithViews();
builder.Services.AddDbContext<CollegeDbContext>();
var app = builder.Build();
app.MapDefaultControllerRoute();
app.Run();




// var db = new CollegeDbContext();

// if(args.Length == 0)
// {
//     foreach(var course in db.Courses)
//         Console.WriteLine("{0, -6}{1, 12}{2, 8}{3, 15}", course.Id, course.name, course.fees, course.duration);
// }
// else
// {
//     string cno = args[0];
//     var course = db.Courses
//                 .Where(p => p.Id == cno)
//                 .Include(p => p.Students)
//                 .FirstOrDefault();
//     if(course != null)
//     {
//         foreach(var student in course.Students)
//             Console.WriteLine("{0}\t{1}\t{2}\t{3}\t{4}", student.Id, student.name, student.age, student.grade, student.CourseId);
//     }
// }

