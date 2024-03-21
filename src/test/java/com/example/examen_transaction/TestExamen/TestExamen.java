package com.example.examen_transaction.TestExamen;

import com.example.examen_transaction.Entities.Bank;
import com.example.examen_transaction.Repository.BankRepository;
import com.example.examen_transaction.Services.IExamenService;
import com.example.examen_transaction.Services.IExamenServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TestExamen {
    @InjectMocks
    private IExamenServiceImpl examenService;
    @Mock
    private BankRepository bankRepository;
    @Test
    public void test_save_new_bank() {
        // Arrange
        BankRepository BankRepository = mock(BankRepository.class);
        IExamenService examenService = new IExamenServiceImpl(bankRepository, null, null);
        Bank bank = new Bank();

        // Act
        when(bankRepository.save(bank)).thenReturn(bank);
        Bank result = examenService.ajouterBank(bank);

        // Assert
        assertEquals(bank, result);
        verify(bankRepository, times(1)).save(bank);
    }
}
