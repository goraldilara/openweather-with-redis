package dg.littleweather.controller;

import dg.littleweather.domain.Operation;
import dg.littleweather.service.OperationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operation")
public class OperationController {

    private final OperationService operationService;

    public OperationController(OperationService operationService){
        this.operationService = operationService;
    }

    @PostMapping("/saveOperation")
    public ResponseEntity<Operation> saveOperation(@RequestBody Operation operation){
        return ResponseEntity.ok(operationService.saveOperation(operation));
    }

    @GetMapping("/getOperation")
    public ResponseEntity<Operation> getOperationById(@RequestBody int id){
        return ResponseEntity.ok(operationService.getOperationById(id));
    }

    @GetMapping("/getAllOperations")
    public ResponseEntity<List<Operation>> getAllOperations(){
        return ResponseEntity.ok(operationService.getAllOperations());
    }

    @PutMapping("/updateOperation")
    public ResponseEntity<Operation> updateOperation(@RequestBody int id, Operation operation){
        return ResponseEntity.ok(operationService.updateOperation(id, operation));
    }

    @DeleteMapping("/deleteOperation")
    public void deleteOperation(@RequestBody Operation operation){
        operationService.deleteOperation(operation.getId());
    }




}
