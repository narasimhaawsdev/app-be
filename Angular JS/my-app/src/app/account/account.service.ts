import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Account } from './account.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AccountService {
  private baseUrl = 'http://localhost:8080/api/banking/accounts';

  constructor(private http: HttpClient) {}

  createAccount(account: Account): Observable<Account> {
    return this.http.post<Account>(\`\${this.baseUrl}\`, account);
  }

  closeAccount(accountId: string): Observable<Account> {
    return this.http.put<Account>(\`\${this.baseUrl}/\${accountId}/close\`, {});
  }

  getAccountSummary(accountId: string): Observable<Account> {
    return this.http.get<Account>(\`\${this.baseUrl}/\${accountId}/summary\`);
  }

  getAccountTypes(): Observable<string[]> {
    return this.http.get<string[]>(\`\${this.baseUrl}/types\`);
  }

  getAccountFees(accountId: string): Observable<number> {
    return this.http.get<number>(\`\${this.baseUrl}/\${accountId}/fees\`);
  }
}
