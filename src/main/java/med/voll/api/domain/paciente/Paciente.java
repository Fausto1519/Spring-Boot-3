package med.voll.api.domain.paciente;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.direccion.Direccion;

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Paciente")
@Table (name = "pacientes")
public class Paciente {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String documentoIdentidad;
    private boolean activo;
    private String telefono;
    private String sexo;

    @Embedded
    Direccion direccion;

    public Paciente(DatosRegistroPaciente datosRegistroPaciente){
        this.activo = true;
        this.nombre = datosRegistroPaciente.nombre();
        this.email = datosRegistroPaciente.email();
        this.documentoIdentidad = datosRegistroPaciente.documentoIdentidad();
        this.telefono = datosRegistroPaciente.telefono();
        this.sexo = datosRegistroPaciente.sexo();
        this.direccion = new Direccion(datosRegistroPaciente.direccion());
    }

    public void actualizarDatos(DatosActualizarPaciente datosActualizarPaciente) {
        if (datosActualizarPaciente.nombre() != null){
            this.nombre = datosActualizarPaciente.nombre();
        }
        if (datosActualizarPaciente.documento() != null){
            this.documentoIdentidad = datosActualizarPaciente.documento();
        }
        if (datosActualizarPaciente.telefono() != null){
            this.telefono = datosActualizarPaciente.telefono();
        }
        if (datosActualizarPaciente.email() != null){
            this.email = datosActualizarPaciente.email();
        }
        if (datosActualizarPaciente.direccion() != null){
            this.direccion = direccion.actualizarDatos(datosActualizarPaciente.direccion());
        }

    }

    public void inactivarPaciente() {
        this.activo = false;
    }
}
