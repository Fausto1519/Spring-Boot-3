package med.voll.api.domain.paciente;

public record DatosListadoPaciente(Long id, String nombre, String sexo, String documentoIdentidad, String email) {
    public DatosListadoPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNombre(), paciente.getSexo(), paciente.getDocumentoIdentidad(), paciente.getEmail());
    }
}

