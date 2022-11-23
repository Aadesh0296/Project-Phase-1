namespace CollegeApp.Services;

public class Course
{
    public string Id { get; set; }

    public string name { get; set; }

    public decimal fees { get; set; }

    public int duration { get; set; }

    public List<Student> Students { get; set; }   
    
}