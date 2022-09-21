public class Estudiante
{
    private String nombre;
    private float[] calificaciones;

    public Estudiante()
    {
        this.calificaciones = new float[5];
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public float[] getCalificaciones()
    {
        return this.calificaciones;
    }

    public void setNombre(String nuevoNombre)
    {
        this.nombre = nuevoNombre;
    }
}
