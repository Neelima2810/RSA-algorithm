# RSA-algorithm
The RSA (Rivest-Shamir-Adleman) algorithm is a widely used public-key cryptosystem for secure data transmission. It uses asymmetric encryption, meaning it uses two keys for encryption and decryption: a public key and a private key.

Key Generation:
Choose two large prime numbers, p and 𝑞
Compute the modulus 𝑛=𝑝×𝑞
n=p×q. This is part of both the public and private keys.
Compute Euler's totient function 𝜙(𝑛)=(𝑝−1)(𝑞−1)
ϕ(n)=(p−1)(q−1).

Encryption Process:
Compute 𝐶≡𝑚^𝑒 mod 𝑛
C is the ciphertext.

Decryption Process 
Compute  m≡C^d modn.
