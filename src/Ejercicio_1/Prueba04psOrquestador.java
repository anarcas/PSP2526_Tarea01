/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio_1;

/**
 *
 * @author anaranjo
 */
public class Prueba04psOrquestador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Nombre de la clase principal (sin .class) para ejecutar
        String productor = "Productor";
        String consumidor = "Consumidor";

        // Crear el ProcessBuilder para el primer programa (Productor)
        ProcessBuilder pbProductor = new ProcessBuilder("java", productor);
        
        // Crear el ProcessBuilder para el segundo programa (Consumidor)
        ProcessBuilder pbConsumidor = new ProcessBuilder("java", consumidor);
        
        // Configuración para forzar UTF-8 en ambos procesos (recomendado)
        pbProductor.environment().put("LANG", "en_US.UTF-8");
        pbConsumidor.environment().put("LANG", "en_US.UTF-8");

        // ----------------------------------------------------
        // MÉTODO DE JAVA 9+: Usando startPipeline()
        // ----------------------------------------------------
        
        List<ProcessBuilder> builders = Arrays.asList(pbProductor, pbConsumidor);
        
        // 1. Iniciar la tubería: Conecta automáticamente el stdout del primero al stdin del segundo.
        List<Process> pipeline = ProcessBuilder.startPipeline(builders);
        
        // 2. Esperar a que el Consumidor (el último proceso de la tubería) termine.
        Process consumidorProcess = pipeline.get(pipeline.size() - 1);
        int exitCode = consumidorProcess.waitFor();
        
        System.out.println("Tubería de procesos completada. Código de salida del Consumidor: " + exitCode);

        // Opcional: Redirigir la salida del último proceso (Consumidor) a la salida estándar del Orquestador
        // Esto es útil si el Consumidor imprime el resultado final. 
        // En este ejemplo, la salida ya se imprimiría si no has redirigido previamente.

        // Si quisieras que el Orquestador esperara la salida del Consumidor:
        // try (BufferedReader reader = new BufferedReader(new InputStreamReader(consumidorProcess.getInputStream()))) {
        //     String line;
        //     while ((line = reader.readLine()) != null) {
        //         System.out.println("[Salida del Consumidor]: " + line);
        //     }
        // }
        
    }
    
}
